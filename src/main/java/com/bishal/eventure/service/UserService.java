package com.bishal.eventure.service;

import com.bishal.eventure.model.User;
import com.bishal.eventure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString().split("-")[0]);
        user.setCreatedAt(LocalDateTime.now());
        return repository.save(user);
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User getUserById(String id) {
        return repository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setEmail(user.getEmail());
            existingUser.setFname(user.getFname());
            existingUser.setLname(user.getLname());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            return repository.save(existingUser);
        }
        return null;
    }

    public String deleteUser(String id) {
        repository.deleteById(id);
        return "User deleted successfully";
    }
}

package com.bishal.eventure.controller;

import com.bishal.eventure.model.User;
import com.bishal.eventure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    // Assume PasswordEncoder bean is available or inject it
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        // Hash the password
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        
        // Call the service to add the user
        return service.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return service.getUserById(id);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        return service.deleteUser(id);
    }
}

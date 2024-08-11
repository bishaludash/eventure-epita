package com.bishal.eventure.service;

import com.bishal.eventure.model.Role;
import com.bishal.eventure.model.Task;
import com.bishal.eventure.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    //    CRUD
    public Role addRole(Role role){
       return repository.save(role);
    }

    public List<Role> findAllRoles(){
        return repository.findAll();
    }

    public Role getRoleById(String id){
        return  repository.findById(id).get();
    }

    public Role updateRole(Role role){
        Role existingRole = repository.findById(role.getId()).get();
        existingRole.setRoleName(role.getRoleName());
        return repository.save(existingRole);
    }

    public String deleteRole(String id){
        repository.deleteById(id);
        return "Role deleted successfully";
    }
}

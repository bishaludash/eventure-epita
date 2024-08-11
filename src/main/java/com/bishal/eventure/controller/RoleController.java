package com.bishal.eventure.controller;

import com.bishal.eventure.model.Role;
import com.bishal.eventure.model.Task;
import com.bishal.eventure.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role createRole(@RequestBody Role role){
        return service.addRole(role);
    }

    @GetMapping
    public List<Role> getAllRole(){
        return service.findAllRoles();
    }

    @GetMapping("/{taskId}")
    public Role getAllRole(@PathVariable String id){
        return service.getRoleById(id);
    }

    @PutMapping
    public Role updateRole(@RequestBody Role role){
        return service.updateRole(role);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTole(@PathVariable String id){
        return service.deleteRole(id);
    }
}

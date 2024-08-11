package com.bishal.eventure.controller;

import com.bishal.eventure.model.Task;
import com.bishal.eventure.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return service.findAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getAllTask(@PathVariable String taskId){
        return service.getTaskByTaskId(taskId);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return service.deleteTask(taskId);
    }
}

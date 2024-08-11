package com.bishal.eventure.service;

import com.bishal.eventure.model.Task;
import com.bishal.eventure.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

//    CRUD
    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        task.setCreatedAt(LocalDateTime.now());
        return repository.save(task);
    }

    public List<Task> findAllTasks(){
        return repository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return  repository.findById(taskId).get();
    }

    public Task updateTask(Task task){
        Task existingTask = repository.findById(task.getTaskId()).get();
        existingTask.setEventId(task.getTaskName());
        existingTask.setTaskName(task.getTaskName());
        existingTask.setDescription(task.getDescription());
        existingTask.setDeadlineAt(task.getDeadlineAt());
        existingTask.setAssignee(task.getAssignee());

        return repository.save(existingTask);
    }


    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return "Task deleted successfully";
    }
}

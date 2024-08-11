package com.bishal.eventure.service;

import com.bishal.eventure.model.Task;
import com.bishal.eventure.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

//    CRUD
    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    public List<Task> findAllTasks(){
        return repository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return  repository.findById(taskId).get();
    }

    public List<Task> getTaskByServerity(int serverity){
        return repository.findByServerity(serverity);
    }

    public Task updateTask(Task task){
        Task existingTask = repository.findById(task.getTaskId()).get();
        existingTask.setDescription(task.getDescription());
        existingTask.setServerity(task.getServerity());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setStoryPoints(task.getStoryPoints());

        return repository.save(existingTask);
    }


    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return "Task deleted successfully";
    }
}

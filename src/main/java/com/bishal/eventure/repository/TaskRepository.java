package com.bishal.eventure.repository;

import com.bishal.eventure.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    //List<Task> findByServerity(int serverity);
}

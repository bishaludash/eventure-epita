package com.bishal.eventure.repository;

import com.bishal.eventure.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

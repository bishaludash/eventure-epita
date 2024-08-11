package com.bishal.eventure.repository;

import com.bishal.eventure.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface RoleRepository extends MongoRepository<Role, String> {

}

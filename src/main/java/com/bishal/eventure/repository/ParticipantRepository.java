package com.bishal.eventure.repository;

import com.bishal.eventure.model.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantRepository extends MongoRepository<Participant, String> {
}



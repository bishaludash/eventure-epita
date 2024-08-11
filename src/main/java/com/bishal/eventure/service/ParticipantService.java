package com.bishal.eventure.service;

import com.bishal.eventure.model.Event;
import com.bishal.eventure.model.Participant;
import com.bishal.eventure.repository.EventRepository;
import com.bishal.eventure.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository repository;

    public Participant addParticipant(Participant data) {
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreatedAt(LocalDateTime.now());
        return repository.save(data);
    }

    public List<Participant> findAllParticipants() {
        return repository.findAll();
    }

    public Participant getParticipantById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Participant updateParticipant(Participant participant) {
        Participant existingEvent = repository.findById(participant.getId()).orElse(null);
        if (existingEvent != null) {
            existingEvent.setEventId(participant.getEventId());
            existingEvent.setUserId(participant.getUserId());
            existingEvent.setStatus(participant.getStatus());

            return repository.save(existingEvent);
        }
        return null;
    }

    public String deleteParticipant(String id) {
        repository.deleteById(id);
        return "Event deleted successfully";
    }
}

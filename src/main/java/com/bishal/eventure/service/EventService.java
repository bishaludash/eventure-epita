package com.bishal.eventure.service;

import com.bishal.eventure.model.Event;
import com.bishal.eventure.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    public Event addEvent(Event event) {
        event.setId(UUID.randomUUID().toString().split("-")[0]);
        event.setCreatedAt(LocalDateTime.now());
        return repository.save(event);
    }

    public List<Event> findAllEvents() {
        return repository.findAll();
    }

    public Event getEventById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Event updateEvent(Event event) {
        Event existingEvent = repository.findById(event.getId()).orElse(null);
        if (existingEvent != null) {
            existingEvent.setName(event.getName());
            existingEvent.setEventDate(event.getEventDate());
            existingEvent.setLocation(event.getLocation());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setManager(event.getManager());
            return repository.save(existingEvent);
        }
        return null;
    }

    public String deleteEvent(String id) {
        repository.deleteById(id);
        return "Event deleted successfully";
    }
}

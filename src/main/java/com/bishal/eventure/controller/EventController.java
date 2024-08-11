package com.bishal.eventure.controller;

import com.bishal.eventure.model.Event;
import com.bishal.eventure.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return service.addEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return service.findAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable String id) {
        return service.getEventById(id);
    }

    @PutMapping
    public Event updateEvent(@RequestBody Event event) {
        return service.updateEvent(event);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable String id) {
        return service.deleteEvent(id);
    }
}

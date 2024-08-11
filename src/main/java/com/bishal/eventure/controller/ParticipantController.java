package com.bishal.eventure.controller;

import com.bishal.eventure.model.Event;
import com.bishal.eventure.model.Participant;
import com.bishal.eventure.service.EventService;
import com.bishal.eventure.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Participant createEvent(@RequestBody Participant event) {
        return service.addParticipant(event);
    }

    @GetMapping
    public List<Participant> getAllEvents() {
        return service.findAllParticipants();
    }

    @GetMapping("/{id}")
    public Participant getEventById(@PathVariable String id) {
        return service.getParticipantById(id);
    }

    @PutMapping
    public Participant updateEvent(@RequestBody Participant event) {
        return service.updateParticipant(event);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable String id) {
        return service.deleteParticipant(id);
    }
}

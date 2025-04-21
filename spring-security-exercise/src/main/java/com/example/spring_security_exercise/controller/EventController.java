package com.example.spring_security_exercise.controller;

import com.example.spring_security_exercise.model.Event;
import com.example.spring_security_exercise.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/add-event")
    public String showAddEventForm() {
        return "admin/add-event";
    }

    @PostMapping("/save-event")
    public String saveEvent(Event event) {
        eventRepository.save(event);
        return "redirect:/admin/events";
    }
}
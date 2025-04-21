package com.example.spring_security_exercise.controller;

import com.example.spring_security_exercise.model.Event;
import com.example.spring_security_exercise.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final EventRepository eventRepository;

    public AdminController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/home")
    public String adminHome(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "admin/home";
    }

    @GetMapping("/events")
    public String showEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "admin/events";
    }
}
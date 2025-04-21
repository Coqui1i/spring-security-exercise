package com.example.spring_security_exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest")
public class GuestController {
    @GetMapping("/home")
    public String guestHome() {
        return "guest/home";
    }
}
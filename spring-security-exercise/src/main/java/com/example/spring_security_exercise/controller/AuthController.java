package com.example.spring_security_exercise.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/redirectByRole")
    public String redirectByRole(Authentication authentication) {
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                return "redirect:/admin/home";
            } else if (authority.getAuthority().equals("ROLE_USER")) {
                return "redirect:/user/home";
            }
        }
        return "redirect:/guest/home";
    }
}
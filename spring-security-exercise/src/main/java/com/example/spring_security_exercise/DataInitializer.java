package com.example.spring_security_exercise;

import com.example.spring_security_exercise.model.Role;
import com.example.spring_security_exercise.model.User;
import com.example.spring_security_exercise.repository.UserRepository;
import jakarta.persistence.Entity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) {
        // Roles
        Role adminRole = new Role();
        adminRole.setName("ADMIN");

        Role userRole = new Role();
        userRole.setName("USER");

        Role guestRole = new Role();
        guestRole.setName("GUEST");

        // Usuarios (PostgreSQL maneja IDs automáticamente)
        User admin = new User();
        admin.setUsername("esteban.caquimbo");
        admin.setPassword(passwordEncoder.encode("santiago192005"));
        admin.setRoles(Set.of(adminRole));

        User user1 = new User();
        user1.setUsername("juan.gil");
        user1.setPassword(passwordEncoder.encode("UserJuan456*"));
        user1.setRoles(Set.of(userRole));

        User user2 = new User();
        user2.setUsername("cristian.oidor");
        user2.setPassword(passwordEncoder.encode("UserCristian789*"));
        user2.setRoles(Set.of(userRole));

        userRepository.saveAll(Set.of(admin, user1, user2));
    }
}
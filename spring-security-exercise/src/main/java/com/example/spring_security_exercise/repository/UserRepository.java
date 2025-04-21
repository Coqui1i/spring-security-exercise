package com.example.spring_security_exercise.repository;

import com.example.spring_security_exercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

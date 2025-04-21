package com.example.spring_security_exercise.repository;

import com.example.spring_security_exercise.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
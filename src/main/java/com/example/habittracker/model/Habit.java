package com.example.habittracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int targetDays;
    private int currentStreak;
    private LocalDate lastMarkedDate;

    @ManyToOne
    private User user;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getTargetDays() { return targetDays; }
    public void setTargetDays(int targetDays) { this.targetDays = targetDays; }

    public int getCurrentStreak() { return currentStreak; }
    public void setCurrentStreak(int currentStreak) { this.currentStreak = currentStreak; }

    public LocalDate getLastMarkedDate() { return lastMarkedDate; }
    public void setLastMarkedDate(LocalDate lastMarkedDate) { this.lastMarkedDate = lastMarkedDate; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

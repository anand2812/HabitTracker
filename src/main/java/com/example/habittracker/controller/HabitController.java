package com.example.habittracker.controller;

import com.example.habittracker.model.Habit;
import com.example.habittracker.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class HabitController {

    @Autowired
    private HabitRepository habitRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("habits", habitRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addHabit(@ModelAttribute Habit habit) {
        habit.setCurrentStreak(0);
        habit.setLastMarkedDate(null);
        habitRepository.save(habit);
        return "redirect:/";
    }

    @PostMapping("/mark/{id}")
    public String markHabit(@PathVariable Long id) {
        Habit habit = habitRepository.findById(id).orElse(null);

        if (habit != null) {
            habit.setCurrentStreak(habit.getCurrentStreak() + 1);
            habit.setLastMarkedDate(LocalDate.now()); // Optional: keep track of last mark
            habitRepository.save(habit);
        }

        return "redirect:/";
    }

}

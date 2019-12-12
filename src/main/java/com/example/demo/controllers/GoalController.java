package com.example.demo.controllers;

import com.example.demo.entities.SavingGoal;
import com.example.demo.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class GoalController {

    @Autowired
    GoalService goalService;

    @GetMapping("/goal/{id}")
    public ResponseEntity<SavingGoal> getGoal(@PathVariable long id) {

        return null;
    }

    @GetMapping("/goal/{userId}")
    public ResponseEntity<Iterable<SavingGoal>> getGoalsForUser(@PathVariable long userId) {
        return new ResponseEntity<>(goalService.findAllSavingGoals(), HttpStatus.OK);
    }

    @PostMapping("/goal")
    public ResponseEntity<SavingGoal> createNewGoal(@RequestBody SavingGoal savingGoal) {
        return new ResponseEntity<>(goalService.createSavingGoal(savingGoal), HttpStatus.CREATED);
        }

    @PutMapping("/goal/{id}")
    public ResponseEntity<SavingGoal> updateGoal(@PathVariable long id) {
        return null;
    }
}


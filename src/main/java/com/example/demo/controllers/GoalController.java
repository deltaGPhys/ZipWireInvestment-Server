package com.example.demo.controllers;

import com.example.demo.entities.SavingGoal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Statement;
import java.util.Date;

@Controller
public class GoalController {

    @GetMapping("/goal/{id}")
    public ResponseEntity<SavingGoal> getGoal(@PathVariable long id) {
        return null;
    }

    @GetMapping("/goal/{userId}")
    public ResponseEntity<Iterable<SavingGoal>> getGoalsForUser(@PathVariable long userId) {
        return null;
    }

//    @PostMapping("/goal")
//    public ResponseEntity<SavingGoal> createNewGoal(@RequestBody SavingGoal savingGoal)
//    {return null;}


}


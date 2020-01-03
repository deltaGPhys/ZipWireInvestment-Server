package com.example.demo.controllers;

import com.example.demo.entities.SavingGoal;
import com.example.demo.entities.User;
import com.example.demo.services.AuthenticationService;
import com.example.demo.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/goals")
public class GoalController {
    private User user;

    @Autowired
    GoalService goalService;

    @Autowired
    AuthenticationService authenticationService;


    @GetMapping("/{id}")
    public ResponseEntity<SavingGoal> getGoal(@PathVariable long id) {
        try {
            return new ResponseEntity<>(goalService.showSavingGoal(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SavingGoal> updateGoal(@PathVariable long id, @RequestBody SavingGoal savingGoal) {
        return new ResponseEntity<>(goalService.updateSavingGoal(id, savingGoal), HttpStatus.OK);
    }

    @GetMapping("/{owner}")
    public ResponseEntity<Iterable<SavingGoal>> getGoalsForUser(@PathVariable User owner) {
            return new ResponseEntity<>(goalService.findAllSavingGoals(owner), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SavingGoal> createNewGoal(@RequestBody SavingGoal savingGoal) {
        return new ResponseEntity<>(goalService.createSavingGoal(savingGoal), HttpStatus.CREATED);
        }

    @GetMapping
    public ResponseEntity<Iterable<SavingGoal>> findAllGoals () {
        return new ResponseEntity<>(goalService.findAllGoals(), HttpStatus.CREATED);
    }

    @DeleteMapping("/goal/{id}")
    public ResponseEntity<Boolean> deleteGoal (long id){
        return new ResponseEntity<>(goalService.deleteSavingGoal(id), HttpStatus.OK);
    }

}


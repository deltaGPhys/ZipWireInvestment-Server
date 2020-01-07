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


    @Autowired
    GoalService goalService;

    @Autowired
    AuthenticationService authenticationService;


    @GetMapping("/show/{userId}")
    public ResponseEntity<Iterable<SavingGoal>> getGoal(@PathVariable long userId) {
        try {
            return new ResponseEntity<>(goalService.showSavingGoalsByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SavingGoal> updateGoal(@PathVariable long id, @RequestBody SavingGoal savingGoal) {
        return new ResponseEntity<>(goalService.updateSavingGoal(id, savingGoal), HttpStatus.OK);
    }

    @GetMapping("/owner/{userName}")
    public ResponseEntity<Iterable<SavingGoal>> getGoalsForUser(@PathVariable String userName) {
            return new ResponseEntity<>(goalService.findAllSavingGoalsByUserName(userName), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SavingGoal> createNewGoal(@RequestBody SavingGoal savingGoal) {
        return new ResponseEntity<>(goalService.createSavingGoal(savingGoal), HttpStatus.CREATED);
        }

    @GetMapping("/showAll")
    public ResponseEntity<Iterable<SavingGoal>> findAllGoals () {
        return new ResponseEntity<>(goalService.findAllGoals(), HttpStatus.CREATED);
    }

    @DeleteMapping("/goal/{goalId}")
    public ResponseEntity<Boolean> deleteGoal (@PathVariable long goalId){
        return new ResponseEntity<>(goalService.deleteSavingGoal(goalId), HttpStatus.OK);
    }

    @GetMapping("/goalId/{goalId}")
    public ResponseEntity<SavingGoal> showIndividualGoalById (@PathVariable long goalId) {
        return new ResponseEntity<>(goalService.getSavingGoalByGoalId(goalId), HttpStatus.OK);
    }

}


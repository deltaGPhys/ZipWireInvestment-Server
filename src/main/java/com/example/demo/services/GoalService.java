package com.example.demo.services;

import com.example.demo.repositories.GoalAccountRepository;
import com.example.demo.repositories.SavingGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    GoalAccountRepository goalAccountRepository;

    @Autowired
    SavingGoalRepository savingGoalRepository;





}

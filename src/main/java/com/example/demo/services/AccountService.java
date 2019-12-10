package com.example.demo.services;

import com.example.demo.entities.accounts.GoalAccount;
import com.example.demo.repositories.CheckingRepository;
import com.example.demo.repositories.GoalAccountRepository;
import com.example.demo.repositories.InvestmentRepository;
import com.example.demo.repositories.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    SavingsRepository savingsRepository;

    @Autowired
    InvestmentRepository investmentRepository;

    @Autowired
    GoalAccountRepository goalAccountRepository;

    public double deposit (double amount) {
        return 0.0;
    }

    public double withdraw (double amount) {
        return 0.0;
    }
}

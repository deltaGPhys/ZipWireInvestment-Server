package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.repositories.CheckingRepository;
import com.example.demo.repositories.GoalAccountRepository;
import com.example.demo.repositories.InvestmentRepository;
import com.example.demo.repositories.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    SavingsRepository savingsRepository;

    @Autowired
    InvestmentRepository investmentRepository;

    @Autowired
    GoalAccountRepository goalAccountRepository;

    public void transfer(Account from, Account to, double amount) {
    }
}

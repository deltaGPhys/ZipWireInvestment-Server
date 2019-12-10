package com.example.demo.services;

import com.example.demo.entities.reports.SpendingReport;
import com.example.demo.repositories.CheckingRepository;
import com.example.demo.repositories.InvestmentRepository;
import com.example.demo.repositories.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Statement;
import java.util.Date;

@Service
public class SpendTracker {
    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    SavingsRepository savingsRepository;

    @Autowired
    InvestmentRepository investmentRepository;

    public SpendingReport trackSpendingForAccount(long accountId, Date date) {
        return new SpendingReport();
    }

    /*looping through each account's transactions
    to find the type of transaction and add
    that transaction to the spend report */

    public SpendingReport trackSpendingForUser(long userId, Date date) {
        return new SpendingReport();
    }
}

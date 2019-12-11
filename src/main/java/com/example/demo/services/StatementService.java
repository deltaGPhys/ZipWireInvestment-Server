package com.example.demo.services;

import org.springframework.stereotype.Service;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.example.demo.entities.reports.Statement;

@Service
public class StatementService {
    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    SavingsRepository savingsRepository;

    @Autowired
    InvestmentRepository investmentRepository;

    @Autowired
    GoalAccountRepository goalAccountRepository;

    @Autowired
    TransactionRepository transactionRepository;


    public  StatementService() {
    }

    public Statement getStatementForAccount(long accountId, Date date){
        return null;
    }

    public Statement getStatementForUser(long userId, Date date){
        return null;
    }

    public Statement create(Statement statement){
        return null;
    }

    public Statement update(long id, Statement newStatementData){
        return null;
    }

    public Boolean delete(long id) {
        return null;
    }

}


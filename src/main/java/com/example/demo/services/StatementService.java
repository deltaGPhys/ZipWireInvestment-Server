package com.example.demo.services;

import com.example.demo.entities.reports.Statement;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Date;

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


    public StatementService() {
    }

    public Statement getStatementForAccount(long accountId, LocalDate date) {
        return null;
    }

    public Statement getStatementForUser(long userId, LocalDate date) {
        return null;
    }

    public Statement create(Statement statement) {
        return null;
    }

    public Statement update(long id, Statement newStatementData) {
        return null;
    }

    public Boolean delete(long id) {
        return null;
    }

    private static void printResult(Object result) {
        if (result == null) {
            System.out.print("NULL");
        } else if (result instanceof Object[]) {
            Object[] row = (Object[]) result;
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                printResult(row[i]);
            }
            System.out.print("]");
        } else if (result instanceof Long || result instanceof Double
                || result instanceof String) {
            System.out.print(result.getClass().getName() + ": " + result);
        } else {
            System.out.print(result);
        }
        System.out.println();
    }
}




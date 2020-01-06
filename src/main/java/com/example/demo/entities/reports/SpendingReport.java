package com.example.demo.entities.reports;

import com.example.demo.entities.Transaction;
import com.example.demo.entities.User;
import com.example.demo.enums.SpendingCategories;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class SpendingReport {

    private User user;
    private LocalDate startDate;
    private LocalDate endDate;
    private double startingTotalBalance;
    private double endingTotalBalance;
    private LocalDate statementDate;
    private List<Transaction> transactions;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getStartingTotalBalance() {
        return startingTotalBalance;
    }

    public void setStartingTotalBalance(double startingTotalBalance) { this.startingTotalBalance = startingTotalBalance; }

    public double getEndingTotalBalance() {
        return endingTotalBalance;
    }

    public void setEndingTotalBalance(double endingTotalBalance) {
        this.endingTotalBalance = endingTotalBalance;
    }

    public LocalDate getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(LocalDate statementDate) {
        this.statementDate = statementDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

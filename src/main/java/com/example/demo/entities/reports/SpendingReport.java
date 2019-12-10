package com.example.demo.entities.reports;

import com.example.demo.entities.User;
import com.example.demo.other.SpendingCategories;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashMap;

public class SpendingReport {

    private User user;
    private Date startDate;
    private Date endDate;
    private double startingTotalBalance;
    private double endingTotalBalance;
    private Date statementDate;
    private HashMap<SpendingCategories,Double> spendingMap;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getStartingTotalBalance() {
        return startingTotalBalance;
    }

    public void setStartingTotalBalance(double startingTotalBalance) {
        this.startingTotalBalance = startingTotalBalance;
    }

    public double getEndingTotalBalance() {
        return endingTotalBalance;
    }

    public void setEndingTotalBalance(double endingTotalBalance) {
        this.endingTotalBalance = endingTotalBalance;
    }

    public Date getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Date statementDate) {
        this.statementDate = statementDate;
    }

    public HashMap<SpendingCategories, Double> getSpendingMap() {
        return spendingMap;
    }

    public void setSpendingMap(HashMap<SpendingCategories, Double> spendingMap) {
        this.spendingMap = spendingMap;
    }
}

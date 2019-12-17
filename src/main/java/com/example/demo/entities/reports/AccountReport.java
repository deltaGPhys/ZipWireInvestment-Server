package com.example.demo.entities.reports;

import com.example.demo.entities.Account;

import java.util.Date;

public class AccountReport <E extends Account>{

    private E account;
    private Date startDate;
    private Date endDate;
    private double startingBalance;
    private double endingBalance;
    private Date statementDate;

    public E getAccount() {
        return account;
    }

    public void setAccount(E account) {
        this.account = account;
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

    public double getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(double startingBalance) {
        this.startingBalance = startingBalance;
    }

    public double getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(double endingBalance) {
        this.endingBalance = endingBalance;
    }

    public Date getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Date statementDate) {
        this.statementDate = statementDate;
    }
}

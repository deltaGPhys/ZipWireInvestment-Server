package com.example.demo.automatons;

import com.example.demo.entities.Investment;
import com.example.demo.services.AccountService;
import com.example.demo.services.InvestmentService;

public class Invester implements Runnable {

    private AccountService accountService;
    private InvestmentService investmentService;

    public Invester(AccountService accountService, InvestmentService investmentService) {
        this.accountService = accountService;
        this.investmentService = investmentService;
    }

    @Override
    public void run() {

    }

    public Investment calculateReturns (Investment investment) {
        return null;
    }
}

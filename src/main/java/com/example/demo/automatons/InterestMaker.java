package com.example.demo.automatons;

import com.example.demo.entities.accounts.Savings;
import com.example.demo.services.AccountService;

public class InterestMaker implements Runnable {

    private AccountService accountService;

    public InterestMaker(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void run() {

    }

    public Savings calculateInterest(Savings savings) {
        return null;
    }
}

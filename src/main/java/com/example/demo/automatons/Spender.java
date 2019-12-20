package com.example.demo.automatons;

import com.example.demo.entities.User;
import com.example.demo.services.AccountService;
import com.example.demo.services.AuthenticationService;

public class Spender implements Runnable {

    private AuthenticationService authenticationService;
    private AccountService accountService;

    public Spender(AuthenticationService authenticationService, AccountService accountService) {
        this.authenticationService = authenticationService;
        this.accountService = accountService;
    }

    @Override
    public void run() {

    }

    public void spendForUser(User user) {

    }
}

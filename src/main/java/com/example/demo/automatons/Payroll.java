package com.example.demo.automatons;

import com.example.demo.entities.User;
import com.example.demo.entities.accounts.Account;
import com.example.demo.services.AccountService;
import com.example.demo.services.AuthenticationService;

public class Payroll implements Runnable {

    private AccountService accountService;
    private AuthenticationService authenticationService;

    public Payroll(AccountService accountService, AuthenticationService authenticationService) {
        this.accountService = accountService;
        this.authenticationService = authenticationService;
    }

    @Override
    public void run() {

    }

    public boolean paySalaryToPerson (User user) {
        return false;
    }

    public Account payToAccount (Account account) {
        return null;
    }

}

package com.example.demo.controllers;

import com.example.demo.entities.accounts.Account;
import com.example.demo.repositories.GoalAccountRepository;
import com.example.demo.repositories.SavingsRepository;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable long id) {
        return null;
    }

    @GetMapping("/accounts")
    public ResponseEntity<Account> getAccounts() {
        return null;
    }

    @PutMapping("/account/{id}")
    public ResponseEntity<Account> modifyAccount(@RequestBody Account account, @PathVariable long id) {
        return null;
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable long id) {
        return null;
    }

    @PutMapping("/account/{id}/close")
    public ResponseEntity<Account> closeAccount(@PathVariable long id) {
        return null;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return null;
    }

    @GetMapping("/accounts/{userId}")
    public ResponseEntity<Iterable<Account>> getAccountsForUser(@PathVariable long userId) {
        return null;
    }
}

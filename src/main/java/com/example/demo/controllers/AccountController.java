package com.example.demo.controllers;

import com.example.demo.entities.accounts.Account;
import com.example.demo.repositories.*;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
public class AccountController {
    private AccountService service;

    @Autowired
    AccountService accountService;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable long id) {
        return new ResponseEntity<>(service.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<Account> getAccounts() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
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

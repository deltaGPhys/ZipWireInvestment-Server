package com.example.demo.controllers;

import com.example.demo.entities.Transaction;
import com.example.demo.entities.accounts.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class TransactionController {

    @GetMapping("/transaction/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable long id) {
        return null;
    }

    @PutMapping("/transaction/{id}")
    public ResponseEntity<Transaction> modifyTransaction(@RequestBody Transaction transaction, @PathVariable long id) {
        return null;
    }

    @DeleteMapping("/transaction/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable long id) {
        return null;
    }

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return null;
    }

    @GetMapping("/transaction/account/{accountId}")
    public ResponseEntity<Iterable<Transaction>> getTransactionsForAccount(@PathVariable long accountId) {
        return null;
    }

    @GetMapping("/transaction/account/{accountId}")
    public ResponseEntity<Iterable<Transaction>> getTransactionsForAccountTimePeriod(@PathVariable long accountId, @RequestParam Date date) {
        return null;
    }

    @GetMapping("/transaction/user/{userId}")
    public ResponseEntity<Iterable<Transaction>> getTransactionsForUser(@PathVariable long userId) {
        return null;
    }

    @GetMapping("/transaction/account/{userId}")
    public ResponseEntity<Iterable<Transaction>> getTransactionsForUserTimePeriod(@PathVariable long userId, @RequestParam Date date) {
        return null;
    }
}

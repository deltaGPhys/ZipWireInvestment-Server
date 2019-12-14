package com.example.demo.controllers;

import com.example.demo.entities.Transaction;
import com.example.demo.entities.accounts.Account;
import com.example.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable long id) {
        return null;
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<Transaction> modifyTransaction(@RequestBody Transaction transaction, @PathVariable long id) {
        return null;
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable long id) {
        return null;
    }

    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(transactionService.createTransaction(transaction),HttpStatus.CREATED);
    }

    @GetMapping("/transaction/account/{accountId}")
    public ResponseEntity<Iterable<Transaction>> getTransactionsForAccount(@PathVariable long accountId) {
        return null;
    }

    @GetMapping("/transactions")
    public ResponseEntity<Iterable<Transaction>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

//    @GetMapping(value="/transaction/account/{accountId}", params = {date})
//    public ResponseEntity<Iterable<Transaction>> getTransactionsForAccountTimePeriod(@PathVariable long accountId, @RequestParam Date date) {
//        return null;
//    }

    @GetMapping("/transaction/user/{userId}")
    public ResponseEntity<Iterable<Transaction>> getTransactionsForUser(@PathVariable long userId) {
        return null;
    }

    @GetMapping("/transaction/account/{userId}")
    public ResponseEntity<Iterable<Transaction>> getTransactionsForUserTimePeriod(@PathVariable long userId, @RequestParam Date date) {
        return null;
    }
}

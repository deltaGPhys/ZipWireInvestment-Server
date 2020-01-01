package com.example.demo.controllers;

import com.example.demo.entities.Transaction;
import com.example.demo.enums.TransactionType;
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
        return verifyTransaction(id) ? new ResponseEntity<>(transactionService.getTransactionById(id), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/transactions")
    public ResponseEntity<Iterable<Transaction>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/transactions/account/{accountId}")
    public ResponseEntity<Iterable<Transaction>> getTransactionsForAccount(@PathVariable long accountId) {
        return new ResponseEntity<>(transactionService.getTransactionsForAccount(accountId), HttpStatus.OK);
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<Transaction> modifyTransaction(@RequestBody Transaction transaction) {
        return verifyTransaction(transaction.getId()) ? new ResponseEntity<>(transactionService.modifyTransaction(transaction),HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity deleteTransaction(@PathVariable long id) {
        return verifyTransaction(id) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED);
    }

    public boolean verifyTransaction(Long id) {
        if (transactionService.getTransactionById(id) != null) {
            return true;
        }
        return false;
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

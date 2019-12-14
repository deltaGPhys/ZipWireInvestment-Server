package com.example.demo.controllers;

import com.example.demo.entities.reports.SpendingReport;
import com.example.demo.services.AccountService;
import com.example.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class TrackerController {

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionService transactionService;


    @GetMapping("/tracker/account/{accountId}")
    public ResponseEntity<SpendingReport> getTrackerForAccount(@PathVariable long accountId) {
        return null;
    }

//    @GetMapping("/tracker/account/{accountId}")
//    public ResponseEntity<SpendingReport> getTrackerForAccountTimePeriod(@PathVariable long accountId, @RequestParam Date date) {
//        return null;
//    }

    @GetMapping("/tracker/user/{userId}")
    public ResponseEntity<SpendingReport> getTrackerForUser(@PathVariable long userId) {
        return null;
    }

    @GetMapping("/tracker/account/{userId}")
    public ResponseEntity<SpendingReport> getTrackerForUserTimePeriod(@PathVariable long userId, @RequestParam Date date) {
        return null;
    }
}
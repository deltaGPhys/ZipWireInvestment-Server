package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferController {

    @Autowired
    AccountService accountService;

    @PostMapping("/transfer")
    public ResponseEntity<Account> transferFunds(@RequestParam long fromAccountId, @RequestParam long toAccountId, @RequestParam double amount) {
        return null;
    }
}

package com.example.demo.controllers;

import com.example.demo.entities.accounts.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferController {

    @PostMapping("/transfer")
    public ResponseEntity<Account> transferFunds(@RequestParam long fromAccountId, @RequestParam long toAccountId, @RequestParam double amount) {
        return null;
    }
}

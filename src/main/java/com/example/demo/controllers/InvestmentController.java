package com.example.demo.controllers;

import com.example.demo.entities.SavingGoal;
import com.example.demo.entities.accounts.Account;
import com.example.demo.entities.investment.Security;
import com.example.demo.entities.investment.SecurityHolding;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class InvestmentController {

    @GetMapping("/investment/{id}")
    public ResponseEntity<Iterable<SecurityHolding>> getHoldings(@PathVariable long id) {
        return null;
    }

    @PostMapping("/investment/{id}")
    public ResponseEntity<Iterable<SecurityHolding>> buyNewSecurity(@PathVariable long id, @RequestParam Security security) {
        return null;
    }

    @PutMapping("/investment/{id}")
    public ResponseEntity<Iterable<SecurityHolding>> modifyHoldings(@PathVariable long id, @RequestParam Iterable<Security> securities) {
        return null;
    }
}

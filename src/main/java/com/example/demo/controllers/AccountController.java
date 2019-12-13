package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.entities.accounts.*;
import com.example.demo.repositories.*;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private AccountService service;

    @Autowired
    AccountService accountService;



    @GetMapping("/account/checking/{id}")
    public ResponseEntity<Checking> getCheckingAccount(@RequestBody User user, @PathVariable long id) {
        return new ResponseEntity<>(service.showAChecking(user), HttpStatus.OK);
    }

    @GetMapping("/account/savings/{id}")
    public ResponseEntity<Checking> getSavingsAccount(@RequestBody User user, @PathVariable long id) {
        return new ResponseEntity<>(service.showSavings(user), HttpStatus.OK);
    }

    @GetMapping("/account/investment/{id}")
    public ResponseEntity<Checking> getInvestmentAccount(@RequestBody User user, @PathVariable long id) {
        return new ResponseEntity<>(service.showInvestments(user), HttpStatus.OK);
    }

    @GetMapping("/account/goalaccount/{id}")
    public ResponseEntity<Checking> getGoalAccount(@RequestBody User user, @PathVariable long id) {
        return new ResponseEntity<>(service.showGoalAccounts(user), HttpStatus.OK);
    }

    @GetMapping("/accounts/checking")
    public ResponseEntity<Checking> getCheckingAccounts(@RequestBody User owner) {
        return new ResponseEntity<>(service.showAllChecking(owner), HttpStatus.OK);
    }

    @GetMapping("/accounts/savings")
    public ResponseEntity<Savings> getSavingsAccounts(@RequestBody User owner) {
        return new ResponseEntity<>(service.showAllSavings(owner), HttpStatus.OK);
    }

    @GetMapping("/accounts/investments")
    public ResponseEntity<Investment> getInvestmentAccounts(@RequestBody User owner) {
        return new ResponseEntity<>(service.showAllInvestments(owner), HttpStatus.OK);
    }

    @GetMapping("/accounts/goalaccount")
    public ResponseEntity<GoalAccount> getGoalAccounts(@RequestBody User owner) {
        return new ResponseEntity<>(service.showAllGoalAccounts(owner), HttpStatus.OK);
    }




    @PutMapping("/account/{id}")
    public ResponseEntity<Account> modifyAccount(@RequestBody Account account, @PathVariable long id) {
        return null;
    }




    @DeleteMapping("/account/checking/{id}")
    public ResponseEntity<Checking> closeCheckingAccount(@RequestBody Checking checking, @PathVariable long id) {
        return new ResponseEntity<>(service.closeChecking(checking, id));
    }

    @DeleteMapping("/account/savings/{id}")
    public ResponseEntity<Savings> closeSavingsAccount(@RequestBody Savings savings, @PathVariable long id) {
        return new ResponseEntity<>(service.closeSavings(savings, id), HttpStatus.OK);
    }

    @DeleteMapping("/account/investment/{id}")
    public ResponseEntity<Investment> closeInvestmentAccount(@RequestBody Investment investment, @PathVariable long id) {
        return new ResponseEntity<>(service.closeInvestments(investment, id));
    }

    @DeleteMapping("/account/goalaccount/{id}")
    public ResponseEntity<GoalAccount> closeGoalAccount(@RequestBody GoalAccount goalAccount, @PathVariable long id) {
        return new ResponseEntity<>(service.closeGoalAccount(goalAccount, id));
    }

    @PostMapping("/accounts/checking")
    public ResponseEntity<Checking> createCheckingAccount(@RequestBody Checking checking, @PathVariable long id) {
        return new ResponseEntity<>(service.createChecking(checking, id));
    }

    @PostMapping("/accounts/savings")
    public ResponseEntity<Savings> createSavingsAccount(@RequestBody Savings savings, @PathVariable long id) {
        return new ResponseEntity<>(service.createSavings(savings, id));
    }

    @PostMapping("/accounts/investment")
    public ResponseEntity<Investment> createInvestmentAccount(@RequestBody Investment investment, @PathVariable long id) {
        return new ResponseEntity<>(service.createInvestments(investment, id));
    }

    @PostMapping("/accounts/goalaccount")
    public ResponseEntity<GoalAccount> createGoalAccount(@RequestBody GoalAccount goalAccount, @PathVariable long id) {
        return new ResponseEntity<>(service.createGoalAccount(goalAccount, id));
    }

    @GetMapping("/accounts/checking/{userId}")
    public ResponseEntity<Iterable<Checking>> getCheckingAccountsForUser(@RequestBody Checking checking, @PathVariable long userId) {
        return new ResponseEntity<>(service.getCheckingBalance(checking));
    }

    @GetMapping("/accounts/savings/{userId}")
    public ResponseEntity<Iterable<Savings>> getSavingsAccountsForUser(@RequestBody Savings savings, @PathVariable long userId) {
        return new  ResponseEntity<>(service.getSavingBalance(savings));
    }

    @GetMapping("/accounts/investment/{userId}")
    public ResponseEntity<Iterable<Investment>> getInvestmentAccountsForUser(@RequestBody Investment investment, @PathVariable long userId) {
        return new ResponseEntity<>(service.getInvestmentBalance(investment));
    }

    @GetMapping("/accounts/goalaccount/{userId}")
    public ResponseEntity<Iterable<GoalAccount>> getGoalAccountsForUser(@RequestBody GoalAccount goalAccount, @PathVariable long userId) {
        return new ResponseEntity<>(service.getGoalAccountBalance(goalAccount));
    }
}

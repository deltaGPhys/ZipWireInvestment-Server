package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.entities.accounts.*;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private AccountService service;

    @Autowired
    AccountService accountService;

    @GetMapping("/account/checking/{id}")
    public ResponseEntity<Checking> getCheckingAccount(@RequestBody User user, @PathVariable long id) {
        return new ResponseEntity<>(service.showAChecking(id), HttpStatus.OK);
    }

    @GetMapping("/account/savings/{id}")
    public ResponseEntity<Savings> getSavingsAccount(@RequestBody User owner, @PathVariable long id) {
        return new ResponseEntity<>(service.showSavings(id), HttpStatus.OK);
    }

    @GetMapping("/account/investment/{id}")
    public ResponseEntity<Investment> getInvestmentAccount(@RequestBody User owner, @PathVariable long id) {
        return new ResponseEntity<>(service.showInvestments(id), HttpStatus.OK);
    }

    @GetMapping("/account/goalaccount/{id}")
    public ResponseEntity<GoalAccount> getGoalAccount(@RequestBody User owner, @PathVariable long id) {
        return new ResponseEntity<>(service.showGoalAccounts(id), HttpStatus.OK);
    }

    @GetMapping("/accounts/checking")
    public ResponseEntity<Checking> getAllCheckingAccounts(@RequestBody User owner) {
        return new ResponseEntity<>(service.showAllChecking(owner), HttpStatus.OK);
    }

    @GetMapping("/accounts/savings")
    public ResponseEntity<Savings> getAllSavingsAccounts(@RequestBody User owner) {
        return new ResponseEntity<>(service.showAllSavings(owner), HttpStatus.OK);
    }

    @GetMapping("/accounts/investments")
    public ResponseEntity<Investment> getAllInvestmentAccounts(@RequestBody User owner) {
        return new ResponseEntity<>(service.showAllInvestments(owner), HttpStatus.OK);
    }

    @GetMapping("/accounts/goalaccount")
    public ResponseEntity<GoalAccount> getAllGoalAccounts(@RequestBody User owner) {
        return new ResponseEntity<>(service.showAllGoalAccounts(owner), HttpStatus.OK);
    }




    @PutMapping("/account/{id}")
    public ResponseEntity<Account> modifyAccount(@RequestBody Account account, @PathVariable long id) {
        return null;
    }




    @DeleteMapping("/account/checking/{id}")
    public ResponseEntity<Checking> closeCheckingAccount(@RequestBody Checking checking, @PathVariable long id) {
        return new ResponseEntity<>(service.closeChecking(checking, id), HttpStatus.OK);
    }

    @DeleteMapping("/account/savings/{id}")
    public ResponseEntity<Savings> closeSavingsAccount(@RequestBody Savings savings, @PathVariable long id) {
        return new ResponseEntity<>(service.closeSavings(savings, id), HttpStatus.OK);
    }

    @DeleteMapping("/account/investment/{id}")
    public ResponseEntity<Investment> closeInvestmentAccount(@RequestBody Investment investment, @PathVariable long id) {
        return new ResponseEntity<>(service.closeInvestments(investment, id), HttpStatus.OK);
    }

    @DeleteMapping("/account/goalaccount/{id}")
    public ResponseEntity<GoalAccount> closeGoalAccount(@RequestBody GoalAccount goalAccount, @PathVariable long id) {
        return new ResponseEntity<>(service.closeGoalAccount(goalAccount, id), HttpStatus.OK);
    }

    @PostMapping("/accounts/checking")
    public ResponseEntity<Checking> createCheckingAccount(@RequestBody Checking checking, @PathVariable User owner) {
        return new ResponseEntity<>(service.createChecking(checking, owner), HttpStatus.CREATED);
    }

    @PostMapping("/accounts/savings")
    public ResponseEntity<Savings> createSavingsAccount(@RequestBody Savings savings, @PathVariable User owner) {
        return new ResponseEntity<>(service.createSavings(savings, owner), HttpStatus.CREATED);
    }

    @PostMapping("/accounts/investment")
    public ResponseEntity<Investment> createInvestmentAccount(@RequestBody Investment investment, @PathVariable User owner) {
        return new ResponseEntity<>(service.createInvestments(investment, owner), HttpStatus.CREATED);
    }

    @PostMapping("/accounts/goalaccount")
    public ResponseEntity<GoalAccount> createGoalAccount(@RequestBody GoalAccount goalAccount, @PathVariable User owner) {
        return new ResponseEntity<>(service.createGoalAccount(goalAccount, owner), HttpStatus.CREATED);
    }

    @GetMapping("/accounts/checking/{userId}")
    public ResponseEntity<Iterable<Checking>> getCheckingAccountsForUser(@RequestBody Checking checking, @PathVariable long userId) {
        return new ResponseEntity<>(service.getCheckingBalance(checking), HttpStatus.OK);
    }

    @GetMapping("/accounts/savings/{userId}")
    public ResponseEntity<Iterable<Savings>> getSavingsAccountsForUser(@RequestBody Savings savings, @PathVariable long userId) {
        return new  ResponseEntity<>(service.getSavingBalance(savings), HttpStatus.OK);
    }

    @GetMapping("/accounts/investment/{userId}")
    public ResponseEntity<Iterable<Investment>> getInvestmentAccountsForUser(@RequestBody Investment investment, @PathVariable long userId) {
        return new ResponseEntity<>(service.getInvestmentBalance(investment), HttpStatus.OK);
    }

    @GetMapping("/accounts/goalaccount/{userId}")
    public ResponseEntity<Iterable<GoalAccount>> getGoalAccountsForUser(@RequestBody GoalAccount goalAccount, @PathVariable long userId) {
        return new ResponseEntity<>(service.getGoalAccountBalance(goalAccount), HttpStatus.OK);
    }
}

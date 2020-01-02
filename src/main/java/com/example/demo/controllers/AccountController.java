package com.example.demo.controllers;

import com.example.demo.entities.*;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/checking")
    public ResponseEntity<Checking> createChecking(@RequestBody Checking checking, User owner) {
        return new ResponseEntity<>(accountService.createChecking(checking, owner), HttpStatus.CREATED);
    }

    @PostMapping("/savings")
    public ResponseEntity<Savings> createSavings(@RequestBody Savings savings, User owner) {
        return new ResponseEntity<>(accountService.createSavings(savings, owner), HttpStatus.CREATED);
    }

    @PostMapping("/investment")
    public ResponseEntity<Investment> createInvestments(@RequestBody Investment investment, User owner) {
        return new ResponseEntity<>(accountService.createInvestments(investment, owner), HttpStatus.CREATED);
    }

    @PostMapping("/goalaccount")
    public ResponseEntity<GoalAccount> createGoalAccount(@RequestBody GoalAccount goalAccount, User owner) {
        return new ResponseEntity<>(accountService.createGoalAccount(goalAccount, owner), HttpStatus.CREATED);
    }


    @GetMapping("/checking/id/{id}")
    public ResponseEntity<Checking> getCheckingAccount(@PathVariable long id) {
        return new ResponseEntity<>(accountService.showAChecking(id), HttpStatus.OK);
    }

    @GetMapping("/savings/id/{id}")
    public ResponseEntity<Savings> getSavingsAccount(@PathVariable long id) {
        return new ResponseEntity<>(accountService.showSavings(id), HttpStatus.OK);
    }

    @GetMapping("/investment/id/{id}")
    public ResponseEntity<Investment> getInvestmentAccount(@PathVariable long id) {
        return new ResponseEntity<>(accountService.showInvestments(id), HttpStatus.OK);
    }

    @GetMapping("/goalaccount/{id}")
    public ResponseEntity<GoalAccount> getGoalAccount(@PathVariable long id) {
        return new ResponseEntity<>(accountService.showGoalAccounts(id), HttpStatus.OK);
    }

    @GetMapping("/checking/{owner}")
    public ResponseEntity<Checking> showAllChecking(@PathVariable User owner) {
        accountService.showAllChecking(owner);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/savings/{owner}")
    public ResponseEntity<Savings> showAllSavings(@RequestBody User owner) {
        accountService.showAllSavings(owner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/investments/{owner}")
    public ResponseEntity<Investment> showAllInvestments(@RequestBody User owner) {
        accountService.showAllInvestments(owner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/goalaccount/{owner}")
    public ResponseEntity<GoalAccount> showAllGoalAccounts(@RequestBody User owner) {
        accountService.showAllGoalAccounts(owner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> modifyAccount(@RequestBody Account account, @PathVariable long id) {
        return null;
    }


    @DeleteMapping("/checking/{id}")
    public ResponseEntity<Checking> closeChecking(@RequestBody Checking checking, @PathVariable long id) {
        accountService.closeChecking(checking, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/savings/{id}")
    public ResponseEntity<Savings> closeSavings(@RequestBody Savings savings, @PathVariable long id) {
        accountService.closeSavings(savings, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/investment/{id}")
    public ResponseEntity<Investment> closeInvestments(@RequestBody Investment investment, @PathVariable long id) {
        accountService.closeInvestments(investment, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/goalaccount/{id}")
    public ResponseEntity<GoalAccount> closeGoalAccount(@RequestBody GoalAccount goalAccount, @PathVariable long id) {
        accountService.closeGoalAccount(goalAccount, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/checking/{userId}")
    public ResponseEntity<Iterable<Checking>> getCheckingAccountsForUser(@RequestBody Checking checking, @PathVariable long userId) {
        accountService.getCheckingBalance(checking);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/savings/{userId}")
    public ResponseEntity<Iterable<Savings>> getSavingsAccountsForUser(@RequestBody Savings savings, @PathVariable long userId) {
        accountService.getSavingBalance(savings);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/investment/{userId}")
    public ResponseEntity<Iterable<Investment>> getInvestmentAccountsForUser(@RequestBody Investment investment, @PathVariable long userId) {
        accountService.getInvestmentBalance(investment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/goalaccount/{userId}")
    public ResponseEntity<Iterable<GoalAccount>> getGoalAccountsForUser(@RequestBody GoalAccount goalAccount, @PathVariable long userId) {
        accountService.getGoalAccountBalance(goalAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

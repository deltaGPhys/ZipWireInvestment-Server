package com.example.demo.controllers;

import com.example.demo.entities.*;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/checking")
    public ResponseEntity<Checking> createChecking(@RequestBody Checking checking, User owner) {
        try {
            return new ResponseEntity<>(accountService.createChecking(checking, owner), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/savings")
    public ResponseEntity<Savings> createSavings(@RequestBody Savings savings, User owner) {
        try {
            return new ResponseEntity<>(accountService.createSavings(savings, owner), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/investment")
    public ResponseEntity<Investment> createInvestments(@RequestBody Investment investment, User owner) {
        try {
            return new ResponseEntity<>(accountService.createInvestments(investment, owner), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/goalaccount")
    public ResponseEntity<GoalAccount> createGoalAccount(@RequestBody GoalAccount goalAccount, User owner) {
        try {
            return new ResponseEntity<>(accountService.createGoalAccount(goalAccount, owner), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/checking/id/{id}")
    public ResponseEntity<Checking> getCheckingAccount(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(accountService.showAChecking(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/savings/id/{id}")
    public ResponseEntity<Savings> getSavingsAccount(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(accountService.showSavings(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/investment/id/{id}")
    public ResponseEntity<Investment> getInvestmentAccount(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(accountService.showInvestments(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/goalaccount/{id}")
    public ResponseEntity<GoalAccount> getGoalAccount(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(accountService.showGoalAccounts(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/checking/{owner}")
    public ResponseEntity<Checking> showAllChecking(@PathVariable User owner) {
        accountService.showAllChecking(owner);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/savings/{owner}")
    public ResponseEntity<Savings> showAllSavings(@RequestBody User owner) {
        accountService.showAllSavings(owner);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/investments/{owner}")
    public ResponseEntity<Investment> showAllInvestments(@RequestBody User owner) {
        accountService.showAllInvestments(owner);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/goalaccount/{owner}")
    public ResponseEntity<GoalAccount> showAllGoalAccounts(@PathVariable Long ownerId) {
        accountService.showAllGoalAccounts(ownerId);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/checking/{id}")
    public ResponseEntity<Checking> closeChecking(@RequestBody Checking checking, @PathVariable Long id) {
        accountService.closeChecking(checking, id);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/savings/{id}")
    public ResponseEntity<Savings> closeSavings(@RequestBody Savings savings, @PathVariable Long id) {
        accountService.closeSavings(savings, id);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/investment/{id}")
    public ResponseEntity<Investment> closeInvestments(@RequestBody Investment investment, @PathVariable Long id) {
        accountService.closeInvestments(investment, id);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/goalaccount/{id}")
    public ResponseEntity<GoalAccount> closeGoalAccount(@RequestBody GoalAccount goalAccount, @PathVariable Long id) {
        accountService.closeGoalAccount(goalAccount, id);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public org.springframework.http.ResponseEntity<Account> closeAccount(@RequestBody Account account, @PathVariable Long id) {
        accountService.closeAccount(account, id);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/checking/{userId}")
    public ResponseEntity<Iterable<Checking>> getCheckingAccountsForUser(@RequestBody Checking checking, @PathVariable Long userId) {
        accountService.getCheckingBalance(checking);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/savings/{userId}")
    public ResponseEntity<Iterable<Savings>> getSavingsAccountsForUser(@RequestBody Savings savings, @PathVariable Long userId) {
        accountService.getSavingBalance(savings);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/investment/{userId}")
    public ResponseEntity<Iterable<Investment>> getInvestmentAccountsForUser(@RequestBody Investment investment, @PathVariable Long userId) {
        accountService.getInvestmentBalance(investment);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/goalaccount/{userId}")
    public ResponseEntity<Iterable<GoalAccount>> getGoalAccountsForUser(@RequestBody GoalAccount goalAccount, @PathVariable Long userId) {
        accountService.getGoalAccountBalance(goalAccount);
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateBalance(@PathVariable Long id, @RequestBody Account account) {
        try {
            return new ResponseEntity<>(accountService.updateBalance(id, account), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }
}

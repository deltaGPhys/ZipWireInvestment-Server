package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;
import com.example.demo.repositories.*;
import com.example.demo.entities.*;
import java.util.*;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    InvestmentRepository investmentRepository;
    @Autowired
    GoalAccountRepository goalAccountRepository;
    @Autowired
    UserRepository userRepository;


    public Checking showAChecking(long id){
        return checkingRepository.findById(id).get();
    }

    public Savings showSavings(long id){
        return savingsRepository.findById(id).get();
    }

    public Investment showInvestments(long id){
        return investmentRepository.findById(id).get();
    }

    public GoalAccount showGoalAccounts(long id){
        return goalAccountRepository.findById(id).get();
    }

    public Checking createChecking(Checking checking, User owner){
//        List<Account> userAccounts = owner.getAccounts();
//        userAccounts.add(checking);
//        userRepository.save(owner);
//        checking.setOwner(user);
        return checkingRepository.save(checking);
    }

    public Savings createSavings(Savings savings, User owner) {
//        List<Account> userAccounts = owner.getAccounts();
//        userAccounts.add(savings);
//        userRepository.save(owner);
        return savingsRepository.save(savings);

    }

    public Investment createInvestments(Investment investment, User owner){
//        List<Account> userAccounts = owner.getAccounts();
//        userAccounts.add(investment);
//        userRepository.save(owner);
        return investmentRepository.save(investment);
    }

    public GoalAccount createGoalAccount(GoalAccount goalAccount, User owner) {
//        List<Account> userAccounts = owner.getAccounts();
//        userAccounts.add(goalAccount);
//        userRepository.save(owner);
        return goalAccountRepository.save(goalAccount);
    }

    public Account showAccount(long id){
        return accountRepository.findById(id).get();
    }

    public Boolean closeAccount(Account account, long id) {
        if(account.getBalance() == 0) {
            accountRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    public Checking depositIntoChecking (Checking checking, double amountToIncreaseBy) {
        if(amountToIncreaseBy < 0) {
            throw new   IllegalArgumentException();
        }
        double checkingBalance = checking.getBalance();
        checkingBalance += amountToIncreaseBy;
        checking.setBalance(checkingBalance);
        return checkingRepository.save(checking);
        }

    public Savings depositIntoSavings (Savings saving, double amountToIncreaseBy) {
        if(amountToIncreaseBy < 0) {
            throw new   IllegalArgumentException();
        }
        double savingBalance = saving.getBalance();
        savingBalance += amountToIncreaseBy;
        saving.setBalance(savingBalance);
        return savingsRepository.save(saving);
    }


    public Investment depositIntoInvestment (Investment investment, double amountToIncreaseBy) {
        if(amountToIncreaseBy < 0) {
            throw new   IllegalArgumentException();
        }
        double investmentBalance = investment.getBalance();
        investmentBalance += amountToIncreaseBy;
        investment.setBalance(investmentBalance);
        return investmentRepository.save(investment);
    }

    public GoalAccount depositIntoGoalAccount (GoalAccount goalAccount, double amountToIncreaseBy) {
        if(amountToIncreaseBy < 0) {
            throw new   IllegalArgumentException();
        }
        double goalAccountBalance = goalAccount.getBalance();
        goalAccountBalance += amountToIncreaseBy;
        goalAccount.setBalance(goalAccountBalance);
        return goalAccountRepository.save(goalAccount);
    }

    public Checking withdrawFromChecking (Checking checking, double amountToDecreaseBy) {
        if(amountToDecreaseBy < 0 || amountToDecreaseBy > checking.getBalance() ) {
            throw new IllegalArgumentException();
        }
        double checkingBalance = checking.getBalance();
        checkingBalance -= amountToDecreaseBy;
        checking.setBalance(checkingBalance);
        return checkingRepository.save(checking);
    }

    public Savings withdrawFromSavings (Savings savings, double amountToDecreaseBy) {
        if(amountToDecreaseBy < 0 || amountToDecreaseBy > savings.getBalance()) {
            throw new IllegalArgumentException();
        }
        double savingsBalance = savings.getBalance();
        savingsBalance -= amountToDecreaseBy;
        savings.setBalance(savingsBalance);
        return savingsRepository.save(savings);
    }

    public Investment withdrawFromInvestment (Investment investment, double amountToDecreaseBy) {
        if(amountToDecreaseBy < 0 || amountToDecreaseBy > investment.getBalance()) {
            throw new IllegalArgumentException();
        }
        double investmentBalance = investment.getBalance();
        investmentBalance -= amountToDecreaseBy;
        investment.setBalance(investmentBalance);
        return investmentRepository.save(investment);
    }

    public GoalAccount withdrawFromGoalAccount (GoalAccount goalAccount, double amountToDecreaseBy) {
        if(amountToDecreaseBy < 0 || amountToDecreaseBy > goalAccount.getBalance()) {
            throw new IllegalArgumentException();
        }
        double goalAccountBalance = goalAccount.getBalance();
        goalAccountBalance -= amountToDecreaseBy;
        goalAccount.setBalance(goalAccountBalance);
        return goalAccountRepository.save(goalAccount);
    }

    public Double getSavingBalance(Savings savings) {
        return savings.getBalance();
    }

    public Double getInvestmentBalance(Investment investment) {
        return investment.getBalance();
    }

    public Double getGoalAccountBalance(GoalAccount goalAccount) {
        return goalAccount.getBalance();
    }

    public Double getCheckingBalance(Checking checking) {
        return checking.getBalance();
    }

    public Iterable<Checking>showAllChecking(User owner){
        return checkingRepository.findAllByOwner(owner);
    }

    public Iterable<Savings>showAllSavings(User owner){
        return savingsRepository.findAll();
    }

    public Iterable<Investment>showAllInvestments(User owner){
        return investmentRepository.findAll();
    }

    public Iterable<GoalAccount>showAllGoalAccounts(User owner){
        return goalAccountRepository.findAll();
    }

    public Boolean closeChecking(Checking checking, long id){
        if(checking.getBalance() == 0){
             checkingRepository.deleteById(id);
            return true;}
        else
            return false;
    }

    public Boolean closeSavings(Savings savings, long id) {
        if(savings.getBalance() == 0) {
            savingsRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    public Boolean closeInvestments(Investment investment, long id) {
        if(investment.getBalance() == 0) {
            investmentRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    public Boolean closeGoalAccount(GoalAccount goalAccount, long id) {
        if(goalAccount.getBalance() == 0) {
            goalAccountRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

}

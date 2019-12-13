package com.example.demo.services;

import com.example.demo.entities.accounts.GoalAccount;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.accounts.*;
import com.example.demo.entities.User;

@Service
public class AccountService {

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

    private double balance;

    public void deposit (double amountToIncreaseBy) {
        if(amountToIncreaseBy < 0) {
            throw new   IllegalArgumentException();
        }
        this.balance += amountToIncreaseBy;
        }

    public void withdraw (double amountToDecreaseBy) {
        if(amountToDecreaseBy < 0 || amountToDecreaseBy > this.balance) {
            throw new IllegalArgumentException();
        }
        this.balance -= amountToDecreaseBy;
    }

    public Double getBalance() {
        return this.balance;
    }

    public Iterable<Checking>showAllChecking(User user){
        return checkingRepository.findAll();
    }

    public Iterable<Savings>showAllSavings(User user){
        return savingsRepository.findAll();
    }

    public Iterable<Investment>showAllInvestments(User user){
        return investmentRepository.findAll();
    }

    public Iterable<GoalAccount>showAllGoalAccounts(User user){
        return goalAccountRepository.findAll();
    }

    public Checking showAChecking(User user){
        long userCheckingId = user.getId();
        return checkingRepository.findCheckingById();
    }

    public Savings showSavings(User user){
        long userSavingsId = user.getId();
        return savingsRepository.findSavingsById();
    }

    public Investment showInvestments(User user){
        long userInvestmentsId = user.getId();
        return investmentRepository.findInvestmentById();
    }

    public GoalAccount showSavingGoalAccounts(User user){
        long userSavingGoalId = user.getId();
        return goalAccountRepository.findGoalAccountById();
    }

    public Checking createChecking(Checking checking, User owner){
        return checkingRepository.save(checking);
    }

    public Savings createSavings(Savings savings, User owner) {
        return savingsRepository.save(savings);

    }

    public Investment createInvestments(Investment investment, User owner){
        return investmentRepository.save(investment);
    }

    public GoalAccount createGoalAccount(GoalAccount goalAccount, User owner) {
        return goalAccountRepository.save(goalAccount);
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

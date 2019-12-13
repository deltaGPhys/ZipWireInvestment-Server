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

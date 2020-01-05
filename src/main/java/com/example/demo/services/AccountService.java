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

    public Iterable<GoalAccount>showAllGoalAccounts(Long ownerId){
        return goalAccountRepository.findAllByOwner_Id(ownerId);
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

    public Account updateBalance(Long id, Account newAccountData){
        Account originalAccount = accountRepository.findById(id).get();
        originalAccount.setBalance(newAccountData.getBalance());
        return accountRepository.save(originalAccount);
    }


}

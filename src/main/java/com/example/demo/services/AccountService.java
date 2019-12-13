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


    public double deposit (double amount) {

        return 0.0;
    }

    public double withdraw (double amount) {
        return 0.0;
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

    public Checking createChecking(User user){

        return checkingRepository.save(user);
    }

    public Savings createSavings(User user) {
        return savingsRepository.save(user);

    }

    public Investment createInvestments(User user){
        return investmentRepository.save(user);
    }

    public GoalAccount createGoalAccount(User user) {
        return goalAccountRepository.save(user);
    }

    public Checking updateChecking(long id, User newUserData) {
        User originalUser = userRepository.findUserById();
        originalUser.setEmail(newUserData.getEmail());
        originalUser.setPassword(newUserData.getPassword());
        return userRepository.save(originalUser);



    }

}

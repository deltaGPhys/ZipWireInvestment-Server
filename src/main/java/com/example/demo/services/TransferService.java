package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.exceptions.InsufficientFundsException;

import com.example.demo.exceptions.NegativeBalanceException;
import com.example.demo.exceptions.OwnershipNotSameException;
import com.example.demo.repositories.CheckingRepository;
import com.example.demo.repositories.GoalAccountRepository;
import com.example.demo.repositories.InvestmentRepository;
import com.example.demo.repositories.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    SavingsRepository savingsRepository;

    @Autowired
    InvestmentRepository investmentRepository;

    @Autowired
    GoalAccountRepository goalAccountRepository;

    @Autowired
    TransferService transferService;

    public void transfer(Account from, Account to, double amount) throws InsufficientFundsException, NegativeBalanceException, OwnershipNotSameException {

        if (from.getBalance() < amount)
            throw new InsufficientFundsException("Insufficient funds");

        else if (from.getBalance() < 0)
            throw new NegativeBalanceException("Account balance below 0.00");

        else if (from.getOwner() != to.getOwner())
            throw new OwnershipNotSameException("Account signer different");

        else
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);


        }
    }










package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.exceptions.InsufficientFundsException;

import com.example.demo.exceptions.NegativeBalanceException;
import com.example.demo.exceptions.OwnershipNotSameException;
import com.example.demo.repositories.*;
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

    @Autowired
    AccountRepository accountRepository;

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
            accountRepository.save(from);
            accountRepository.save(to);


        }
    }










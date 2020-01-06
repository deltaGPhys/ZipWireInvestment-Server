package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.entities.Transaction;
import com.example.demo.enums.TransactionType;
import com.example.demo.exceptions.InsufficientFundsException;

import com.example.demo.exceptions.NegativeBalanceException;
import com.example.demo.exceptions.OwnershipNotSameException;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionRepository transactionRepository;

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


        Transaction transactionFrom = new Transaction(from.getId(),TransactionType.TRANSFER,amount,from,String.format("Transferred %.2f from account %d to account %d",amount,from.getId(),to.getId()), LocalDate.now(),from.getBalance());
        transactionService.createTransaction(transactionFrom);


        Transaction transactionTo = new Transaction(to.getId(),TransactionType.TRANSFER,amount,to,String.format("Transferred %.2f to account %d to from %d",amount,to.getId(),from.getId()), LocalDate.now(),to.getBalance());
        transactionService.createTransaction(transactionTo);




    }

    public void withdraw(Account from, double amount) throws InsufficientFundsException, NegativeBalanceException {
        if (from.getBalance() < amount)
            throw new InsufficientFundsException("Insufficient funds");

        else if (from.getBalance() < 0)
            throw new NegativeBalanceException("Account balance below 0.00");
        else
            from.setBalance(from.getBalance() - amount);
        accountRepository.save(from);
        Transaction transaction = new Transaction(from.getId(),TransactionType.WITHDRAWAL,amount,from,String.format("Withdrew %.2f from account %d", amount,from.getId()), LocalDate.now(),from.getBalance());
        transactionService.createTransaction(transaction);
    }

    public void deposit( Account to, double amount) {
        to.setBalance(to.getBalance() + amount);
        accountRepository.save(to);
        Transaction transaction = new Transaction(to.getId(),TransactionType.DEPOSIT,amount,to,String.format("Deposited %.2f to account %d", amount,to.getId()), LocalDate.now(),to.getBalance());
        transactionService.createTransaction(transaction);
    }


}










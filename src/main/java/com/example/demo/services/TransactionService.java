package com.example.demo.services;

import com.example.demo.entities.Transaction;
import com.example.demo.entities.User;
import com.example.demo.entities.Account;
import com.example.demo.enums.TransactionType;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Iterable<Transaction> getAllTransactions () {
        return transactionRepository.findAll();
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsById (long id) {
        return null;
    }

    public Transaction getTransactionById (long id) {
        return null;
    }

    public List<Transaction> getTransactionsForAccount (Account account) {
        return null;
    }

    public List<Transaction> getTransactionsForUser (User user) {
        return null;
    }
}

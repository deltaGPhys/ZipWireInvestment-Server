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

    public boolean verifyTransaction(Long id) {
        return transactionRepository.existsById(id);
    }

    public Iterable<Transaction> getAllTransactions () {
        return transactionRepository.findAll();
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction getTransactionById (long id) {
        return transactionRepository.findById(id).get();
    }

    public Iterable<Transaction> getTransactionsForAccount (Long id) {
        return transactionRepository.findTransactionByAccount_Id(id);
    }

    public Transaction modifyTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }


}

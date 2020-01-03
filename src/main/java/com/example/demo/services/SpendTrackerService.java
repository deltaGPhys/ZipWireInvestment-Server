package com.example.demo.services;

import com.example.demo.dto.ReportRequestDto;
import com.example.demo.entities.Account;
import com.example.demo.entities.Transaction;
import com.example.demo.entities.reports.SpendingReport;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SpendTrackerService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(long accountId){
        Optional<Account> accountResult = accountRepository.findById(accountId);
        return accountResult.orElse(null);
    }

    public ResponseEntity<SpendingReport> getReportForAccount(long accountId, ReportRequestDto requestDto) {
        SpendingReport spendingReport = new SpendingReport();
        List<Transaction> transactions = new ArrayList<>();

        transactionRepository.findTransactionsByDateCreatedBetween(requestDto.getStartDate(), requestDto.getEndDate()).iterator().forEachRemaining(transactions::add);

        spendingReport.setUser(getAccount(accountId).getOwner());
        spendingReport.setStartDate(requestDto.getStartDate());
        spendingReport.setEndDate(requestDto.getEndDate());
        spendingReport.setStartingTotalBalance(transactions.get(0).getAccountBalance());
        spendingReport.setEndingTotalBalance(transactions.get(transactions.size()-1).getAccountBalance());
        spendingReport.setStatementDate(new Date());
        spendingReport.setTransactions(transactions);


        return new ResponseEntity<>(spendingReport, HttpStatus.OK);
    }

    /*looping through each account's transactions
    to find the type of transaction and add
    that transaction to the spend report */
}

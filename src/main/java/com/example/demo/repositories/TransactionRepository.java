package com.example.demo.repositories;

import com.example.demo.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Iterable<Transaction> findTransactionsByDateCreatedBetween(Date startDate, Date endDate);

    Iterable<Transaction> findTransactionByAccount_Id(Long id);
}

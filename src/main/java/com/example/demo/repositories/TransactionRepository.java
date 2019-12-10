package com.example.demo.repositories;

import com.example.demo.entities.Transaction;
import com.example.demo.entities.accounts.Savings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}

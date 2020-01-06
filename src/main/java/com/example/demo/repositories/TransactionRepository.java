package com.example.demo.repositories;

import com.example.demo.entities.Transaction;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

//    @Query("SELECT e FROM Transaction e WHERE e.transaction BETWEEN startDate AND endDate")
    Iterable<Transaction> findTransactionsByDateCreatedBetween(@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate);

    @Query("SELECT e FROM Transaction e")
    Iterable<Transaction> findTransactionByAccount_Id(Long id);

//    Iterable<Transaction> findAllByDateCreated(Date dateCreated);
}
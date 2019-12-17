package com.example.demo.repositories;

import com.example.demo.entities.Savings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends CrudRepository<Savings, Long> {
    Savings findSavingsById();
}

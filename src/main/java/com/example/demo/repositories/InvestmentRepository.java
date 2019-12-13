package com.example.demo.repositories;

import com.example.demo.entities.accounts.Investment;
import com.example.demo.entities.accounts.Savings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends CrudRepository<Investment, Long> {
     Investment findInvestmentById();

}

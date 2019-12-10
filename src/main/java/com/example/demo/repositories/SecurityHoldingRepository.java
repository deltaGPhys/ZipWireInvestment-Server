package com.example.demo.repositories;

import com.example.demo.entities.accounts.Savings;
import com.example.demo.entities.investment.SecurityHolding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityHoldingRepository extends CrudRepository<SecurityHolding, Long> {
}

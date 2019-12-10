package com.example.demo.repositories;

import com.example.demo.entities.accounts.GoalAccount;
import com.example.demo.entities.accounts.Savings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalAccountRepository extends CrudRepository<GoalAccount, Long> {
}

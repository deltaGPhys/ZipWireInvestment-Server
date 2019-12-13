package com.example.demo.repositories;

import com.example.demo.entities.SavingGoal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.accounts.GoalAccount;

@Repository
public interface SavingGoalRepository extends CrudRepository<SavingGoal, Long> {

}

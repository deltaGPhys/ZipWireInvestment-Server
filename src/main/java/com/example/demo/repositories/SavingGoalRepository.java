package com.example.demo.repositories;

import com.example.demo.entities.SavingGoal;
import com.example.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingGoalRepository extends CrudRepository<SavingGoal, Long> {

    Iterable<SavingGoal> findAllByOwnerIdEquals(Long id);
    Iterable<SavingGoal> findAllByOwnerEmail(String email);

}

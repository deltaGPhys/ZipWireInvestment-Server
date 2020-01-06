package com.example.demo.repositories;

import com.example.demo.entities.GoalAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalAccountRepository extends CrudRepository<GoalAccount, Long> {

    public Iterable<GoalAccount> findAllByOwner_Id(Long id);

}

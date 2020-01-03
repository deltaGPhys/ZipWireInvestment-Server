package com.example.demo.repositories;

import com.example.demo.entities.Investment;
import com.example.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends CrudRepository<Investment, Long> {

    public Investment findFirstByOwner(User user);

    public Iterable<Investment> findAllByOwner(User user);

}

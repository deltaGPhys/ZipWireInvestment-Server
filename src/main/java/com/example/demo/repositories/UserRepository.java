package com.example.demo.repositories;

import com.example.demo.entities.User;
import com.example.demo.entities.accounts.Savings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById();
}

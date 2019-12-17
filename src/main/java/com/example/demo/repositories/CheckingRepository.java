package com.example.demo.repositories;

<<<<<<< HEAD
import com.example.demo.entities.Checking;
=======
import com.example.demo.entities.accounts.Checking;
>>>>>>> 0d144c1c95f1d9d76e12966d3274a81e98629895
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends CrudRepository<Checking, Long> {

}

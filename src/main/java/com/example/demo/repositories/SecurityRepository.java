package com.example.demo.repositories;

import com.example.demo.entities.investment.Security;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends CrudRepository<Security, Long> {

    public Security findByIdAndSymbolAndName(long id, String symbol, String name);
}

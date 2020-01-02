package com.example.demo.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Checking extends Account {

    public Checking(long id, double balance, LocalDate openingDate, User owner, String acctName) {
        super(id, balance, openingDate, owner, acctName);
    }

    public Checking(double balance, LocalDate openingDate, User owner, String acctName) {
        super(balance, openingDate, owner, acctName);
    }

    public Checking() {
    }
}


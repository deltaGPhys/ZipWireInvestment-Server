package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public abstract class Account {

    @Id
    @GeneratedValue
    private Long id;
    private double balance;
    private LocalDate openingDate;
    @ManyToOne
    private User owner;
    private String acctName;


    public Account(long id, double balance, LocalDate openingDate, User owner, String acctName) {
        this.id = id;
        this.balance = balance;
        this.openingDate = openingDate;
        this.owner = owner;
        this.acctName = acctName;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }
}

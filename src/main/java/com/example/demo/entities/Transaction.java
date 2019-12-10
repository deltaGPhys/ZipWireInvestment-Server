package com.example.demo.entities;

import com.example.demo.entities.accounts.Account;
import com.example.demo.enums.TransactionType;

import javax.persistence.*;

@Entity
public class Transaction<E extends Account> {

    @Id
    @GeneratedValue
    private long id;
    private TransactionType type;
    private double amount;
    @ManyToOne
    private E account;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public E getAccount() {
        return account;
    }

    public void setAccount(E account) {
        this.account = account;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


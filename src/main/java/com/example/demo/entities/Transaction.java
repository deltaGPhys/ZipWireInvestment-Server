package com.example.demo.entities;

import com.example.demo.enums.TransactionType;
import com.example.demo.serializers.AccountDeserializer;
import com.example.demo.serializers.AccountSerializer;
import com.example.demo.serializers.TransactionTypeDeserializer;
import com.example.demo.serializers.TransactionTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private long id;
    @JsonSerialize(using = TransactionTypeSerializer.class)
    @JsonDeserialize(using = TransactionTypeDeserializer.class)
    private TransactionType type;
    private double amount;
    @ManyToOne
    @JsonSerialize(using = AccountSerializer.class)
    @JsonDeserialize(using = AccountDeserializer.class)
    private Account account;
    private String comment;
    private LocalDate dateCreated;
    private Double accountBalance;

    public Transaction(TransactionType type, double amount, Account account, String comment, LocalDate dateCreated, Double accountBalance) {
        this.type = type;
        this.amount = amount;
        this.account = account;
        this.comment = comment;
        this.dateCreated = dateCreated;
        this.accountBalance = accountBalance;
    }

    public Transaction(Long id, TransactionType type, double amount, Account account, String comment, LocalDate dateCreated, Double accountBalance) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.account = account;
        this.comment = comment;
        this.dateCreated = dateCreated;
        this.accountBalance = accountBalance;
    }

    public Transaction() {
    }

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance() {
        this.accountBalance = this.account.getBalance();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", account=" + account +
                ", comment='" + comment + '\'' +
                ", dateCreated=" + dateCreated +
                ", accountBalance=" + accountBalance +
                '}';
    }
}


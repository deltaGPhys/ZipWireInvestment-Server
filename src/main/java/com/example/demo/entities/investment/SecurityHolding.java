package com.example.demo.entities.investment;

import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class SecurityHolding {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JsonIgnoreProperties("account")
    private Account account;
    @ManyToOne
    @JsonIgnoreProperties("security")
    private Security security;
    private double numShares;
    private double value;
    private double purchaseCost;
    private LocalDate purchaseDate;

    public SecurityHolding() {
    }

    public SecurityHolding(Account account, Security security, double numShares, double value, double purchaseCost, LocalDate purchaseDate) {
        this.account = account;
        this.security = security;
        this.numShares = numShares;
        this.value = value;
        this.purchaseCost = purchaseCost;
        this.purchaseDate = purchaseDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public double getNumShares() {
        return numShares;
    }

    public void setNumShares(double numShares) {
        this.numShares = numShares;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}

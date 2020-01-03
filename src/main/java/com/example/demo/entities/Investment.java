package com.example.demo.entities;

import com.example.demo.entities.investment.SecurityHolding;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Investment extends Account {

    @OneToMany
    @JsonIgnoreProperties("account")
    private List<SecurityHolding> holdings;

    public Investment(List<SecurityHolding> holdings) {
        this.holdings = holdings;
    }

    public Investment(double balance, LocalDate openingDate, User owner, String acctName, List<SecurityHolding> holdings) {
        super(balance, openingDate, owner, acctName);
        this.holdings = holdings;
    }

    public Investment() {
    }

    public List<SecurityHolding> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<SecurityHolding> holdings) {
        this.holdings = holdings;
    }

}

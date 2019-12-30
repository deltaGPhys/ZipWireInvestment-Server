package com.example.demo.entities;

import com.example.demo.entities.investment.SecurityHolding;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Investment extends Account {

    @OneToMany
    private List<SecurityHolding> holdings;

    public List<SecurityHolding> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<SecurityHolding> holdings) {
        this.holdings = holdings;
    }
}

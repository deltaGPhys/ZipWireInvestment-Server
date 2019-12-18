package com.example.demo.entities;


import javax.persistence.Entity;

@Entity
public class Savings extends Account {

    private double rate;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}

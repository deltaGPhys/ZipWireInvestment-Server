package com.example.demo.entities.investment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Security {

    @Id
    private long id;
    private String symbol;
    private String name;
    private double shareCost;

    public Security(String symbol, String name, double shareCost) {
        this.symbol = symbol;
        this.name = name;
        this.shareCost = shareCost;
    }

    public Security(long id, String symbol, String name, double shareCost) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.shareCost = shareCost;
    }

    public Security(long id, String symbol, String name) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.shareCost = 0.0;
    }

    public Security() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getShareCost() {
        return shareCost;
    }

    public void setShareCost(double shareCost) {
        this.shareCost = shareCost;
    }

    @Override
    public String toString() {
        return "Security{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", shareCost=" + shareCost +
                '}';
    }
}

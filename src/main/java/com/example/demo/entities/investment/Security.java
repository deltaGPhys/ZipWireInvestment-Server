package com.example.demo.entities.investment;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.TreeMap;

@Entity
public class Security {

    @Id
    private Long id;
    private String symbol;
    private String name;
    private Double currentPrice;
    @Column(length=100000)
    @JsonIgnore
    private TreeMap<LocalDate, Double> prices;
    private Double dayChange;
    private Double dayChangePct;

    public Security(String symbol, String name, double shareCost) {
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = shareCost;
    }

    public Security(long id, String symbol, String name, double shareCost) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = shareCost;
    }

    public Security(long id, String symbol, String name, double currentPrice, double dayChange, double dayChangePct) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = currentPrice;
        this.dayChange = dayChange;
        this.dayChangePct = dayChangePct;
    }

    public Security(long id, String symbol, String name) { // constructor when there's no row in the table
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = 0.0;
        this.dayChange = 0.0;
        this.dayChangePct = 0.0;
        this.prices = new TreeMap<LocalDate, Double>();
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

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getDayChange() {
        return dayChange;
    }

    public void setDayChange(double dayChange) {
        this.dayChange = dayChange;
    }

    public double getDayChangePct() {
        return dayChangePct;
    }

    public void setDayChangePct(double dayChangePct) {
        this.dayChangePct = dayChangePct;
    }

    public TreeMap<LocalDate, Double> getPrices() {
        return prices;
    }

    public void setPrices(TreeMap<LocalDate, Double> prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "Security{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                ", dayChange=" + dayChange +
                ", dayChangePct=" + dayChangePct +
                '}';
    }
}

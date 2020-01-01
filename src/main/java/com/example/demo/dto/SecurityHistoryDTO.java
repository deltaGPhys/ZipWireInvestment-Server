package com.example.demo.dto;

import com.example.demo.entities.investment.Security;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;


public class SecurityHistoryDTO {

    @JsonIgnore
    private Security security;
    private Long id;
    private LinkedList<LocalDate> dates = new LinkedList<>();
    private LinkedList<Double> prices = new LinkedList<>();
    private LocalDate startDate;

    public SecurityHistoryDTO(Security security, LocalDate startDate) {
        this.security = security;
        this.id = this.security.getId();
        this.startDate = startDate;
        fillPrices();
    }

    public SecurityHistoryDTO(Security security) {
        this.security = security;
        this.id = this.security.getId();
        this.startDate = LocalDate.now().minusYears(1);
        fillPrices();
    }

    public void fillPrices() {
        for (Map.Entry<LocalDate, Double> entry: this.security.getPrices().entrySet()) {
            if (entry.getKey().isAfter(this.startDate)){
                dates.push(entry.getKey());
                prices.push(entry.getValue());
            }
        }
    }

    public LinkedList<Double> getPrices() {
        return prices;
    }

    public Long getId() {
        return id;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public LinkedList<LocalDate> getDates() {
        return dates;
    }

    public void setDates(LinkedList<LocalDate> dates) {
        this.dates = dates;
    }

    public void setPrices(LinkedList<Double> prices) {
        this.prices = prices;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "SecurityHistoryDTO{" +
                "id=" + id +
                ", dates=" + dates +
                ", prices=" + prices +
                ", startDate=" + startDate +
                '}';
    }
}

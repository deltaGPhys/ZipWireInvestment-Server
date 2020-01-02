package com.example.demo.entities.reports;

import com.example.demo.entities.SavingGoal;
import com.example.demo.entities.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GoalReport {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private SavingGoal goal;
    @ManyToOne
    private User owner;
    private double savingsRemaining;
    private int daysRemaining;  //Should we do this by week?
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SavingGoal getGoal() {
        return goal;
    }

    public void setGoal(SavingGoal goal) {
        this.goal = goal;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public double getSavingsRemaining() {
        return savingsRemaining;
    }

    public void setSavingsRemaining(double savingsRemaining) {
        this.savingsRemaining = savingsRemaining;
    }

    public int getDaysRemaining() {
        return daysRemaining;
    }

    public void setDaysRemaining(int daysRemaining) {
        this.daysRemaining = daysRemaining;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

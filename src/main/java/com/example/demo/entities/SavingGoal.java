package com.example.demo.entities;

import com.example.demo.serializers.AccountDeserializer;
import com.example.demo.serializers.AccountSerializer;
import com.example.demo.serializers.UserDeserializer;
import com.example.demo.serializers.UserSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class SavingGoal {

    @Id
    @GeneratedValue
    private long id;
    private double goalAmount;
    @ManyToOne
    @JsonSerialize(using = UserSerializer.class)
    @JsonDeserialize(using = UserDeserializer.class)
    private User owner;
    @OneToOne
    @JsonSerialize(using = AccountSerializer.class)
    @JsonDeserialize(using = AccountDeserializer.class)
    private GoalAccount account;
    private LocalDate endDate;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(double goalAmount) {
        this.goalAmount = goalAmount;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public GoalAccount getAccount() {
        return account;
    }

    public void setAccount(GoalAccount account) {
        this.account = account;
    }
}

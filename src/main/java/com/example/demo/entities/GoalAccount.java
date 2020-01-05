package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class GoalAccount extends Account {

    @JsonSerialize
    @OneToOne
    private SavingGoal goal;

    public GoalAccount(long id, double balance, LocalDate openingDate, User owner, String acctName, SavingGoal goal){
        super(id, balance, openingDate, owner, acctName);
        this.goal = goal;
    }

    public GoalAccount(double balance, LocalDate openingDate, User owner, String acctName, SavingGoal goal) {
        super(balance, openingDate, owner, acctName);
        this.goal = goal;
    }

    public GoalAccount() {}

    public SavingGoal getGoal() {
        return goal;
    }

    public void setGoal(SavingGoal goal) {
        this.goal = goal;
    }

}


    //    @Id
//    @GeneratedValue
//    private long id;
//    @ManyToOne
//    private User owner;
//    @OneToOne
//    private SavingGoal goal;
//
//    @Override
//    public Long getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Override
//    public User getOwner() {
//        return owner;
//    }
//
//    @Override
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }





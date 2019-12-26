package com.example.demo.entities;

import javax.persistence.*;

@Entity
public class GoalAccount extends Account {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User owner;
    @OneToOne
    private SavingGoal goal;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    @Override
    public void setOwner(User owner) {
        this.owner = owner;
    }

    public SavingGoal getGoal() {
        return goal;
    }

    public void setGoal(SavingGoal goal) {
        this.goal = goal;
    }
}

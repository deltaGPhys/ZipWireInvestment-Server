package com.example.demo.entities;

import com.example.demo.serializers.UserDeserializer;
import com.example.demo.serializers.UserSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@Entity
public class GoalAccount extends Account {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JsonSerialize(using = UserSerializer.class)
    @JsonDeserialize(using = UserDeserializer.class)
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

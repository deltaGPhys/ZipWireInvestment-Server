package com.example.demo.entities.investment;

import com.example.demo.entities.User;

import javax.persistence.*;

@Entity
public class SecurityHolding {

    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private User owner;
    @ManyToOne
    private Security security;
    private double numShares;
    private double value;

}

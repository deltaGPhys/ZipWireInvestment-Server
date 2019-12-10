package com.example.demo.entities.investment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Security {

    @Id
    @GeneratedValue
    private long id;
    private String symbol;
    private String name;
    private double shareCost;
}

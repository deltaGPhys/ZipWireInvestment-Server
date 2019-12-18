package com.example.demo.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User testUser;
    private Checking tc1, tc2;
    private Savings ts1;
    private SavingGoal tsg1;
    ArrayList<Account> accounts;

    @BeforeEach
    void setUp() {
        accounts.add(tc1);
        testUser = new User("John", "Doe", "myemail@gmail.com", "password", accounts, 1200.00, 75000.00);
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void setFirstName() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void setEmail() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void getAccounts() {
    }

    @Test
    void setAccounts() {
    }

    @Test
    void getRent() {
    }

    @Test
    void setRent() {
    }

    @Test
    void getSalary() {
    }

    @Test
    void setSalary() {
    }
}
package com.example.demo.entities;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class TransactionTest {
    private User testUser;
    private Checking tc1, tc2;
    ArrayList<Account> accounts = new ArrayList<>();

    @BeforeEach
    void setUp() {
        accounts.add(tc1);
        accounts.add(tc2);
        testUser = new User(43L, "John", "Doe", "myemail@gmail.com", "Thep@ssword1", accounts, 1200.00, 75000.00);
    }
}

package com.example.demo.entities;

import com.example.demo.authentication.CustomPassWordEncoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


class UserTest {
    private User testUser;
    private Checking tc1, tc2;
    private Savings ts1;
    private GoalAccount tsg1;
    ArrayList<Account> accounts = new ArrayList<>();

    @BeforeEach
    void setUp() {
        accounts.add(tc1);
        accounts.add(tc2);
        accounts.add(ts1);
        accounts.add(tsg1);
        testUser = new User(43L, "John", "Doe", "myemail@gmail.com", "Thep@ssword1", accounts, 1200.00, 75000.00);
    }

    @Test
    void getId () {
        Assertions.assertEquals(43L, testUser.getId());
    }

    @Test
    void getLastName() {
        Assertions.assertEquals("Doe", testUser.getLastName());
    }

    @Test
    void getFirstName() {
        Assertions.assertEquals("John", testUser.getFirstName());
    }

    @Test
    void getEmail() {
        Assertions.assertEquals("myemail@gmail.com", testUser.getEmail());
    }

    @Test
    void getPassword() {
        Assertions.assertEquals("Thep@ssword1", testUser.getPassword());
    }

    @Test
    void getAccounts() {
        Assertions.assertEquals(accounts, testUser.getAccounts());
    }

    @Test
    void getRent() {
        Assertions.assertEquals(1200.00, testUser.getRent());
    }

    @Test
    void getSalary() {
        Assertions.assertEquals(75000.00, testUser.getSalary());
    }

    @Test
    void setLastName() {
        String expected = "Doan";
        testUser.setLastName(expected);
        Assertions.assertEquals(expected, testUser.getLastName());
    }

    @Test
    void setFirstName() {
        String expected = "Jane";
        testUser.setFirstName(expected);
        Assertions.assertEquals(expected, testUser.getFirstName());
    }

    @Test
    void setEmail() {
        String expected = "thisNewEmail@yahoo.com";
        testUser.setEmail(expected);
        Assertions.assertEquals(expected, testUser.getEmail());
    }

    @Test
    void setEmail2() {
        String expected = "PeteyG@yahoo.com";
        testUser.setEmail(expected);
        Assertions.assertEquals(expected, testUser.getEmail());
    }

    @Test
    void setPassword() {
        CustomPassWordEncoder encoder = new CustomPassWordEncoder();
        String expected = "myNewPassword!82";
        testUser.setPassword(expected);
        String hashedNSalted = testUser.getPassword();
        boolean check = encoder.matches(expected, hashedNSalted);
        Assertions.assertTrue(check);
    }

    @Test
    void setPassword2() {
        String expected = "ineedapassword";
        testUser.setPassword(expected);
        //Password won't change because it doesn't meet the criteria
        Assertions.assertEquals("Thep@ssword1", testUser.getPassword());
    }

    @Test
    void setAccounts() {
        Checking newCheck = new Checking();
        accounts.add(newCheck);
        testUser.setAccounts(accounts);
        Assertions.assertEquals(accounts, testUser.getAccounts());
    }

    @Test
    void setAccounts2() {
        Checking newCheck = new Checking();
        accounts.add(newCheck);
        testUser.setAccounts(accounts);
        Assertions.assertEquals(accounts.size(), testUser.getAccounts().size());
    }

    @Test
    void setRent() {
        double expected = 1050.00;
        testUser.setRent(expected);
        Assertions.assertEquals(expected, testUser.getRent());
    }

    @Test
    void setSalary() {
        double expected = 78000.00;
        testUser.setSalary(expected);
        Assertions.assertEquals(expected, testUser.getSalary());
    }
}
package com.example.demo.entities;

import com.example.demo.entities.accounts.Account;
import javafx.scene.control.PasswordField;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String lastName;
    private String firstName;
    private Email email;
    private PasswordField password;
    @OneToMany
    private List<Account> accounts;
    private double rent;
    private double salary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Email getEmail() {
        return email;
    }

   public void setEmail(Email email) {
       this.email = email;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public List<? extends Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<? extends Account> accounts) {
        this.accounts = accounts;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

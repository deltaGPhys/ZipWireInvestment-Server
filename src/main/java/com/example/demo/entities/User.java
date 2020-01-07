package com.example.demo.entities;


import com.example.demo.authentication.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "This field cannot be left blank")
    private String firstName;
    @NotBlank(message = "This field cannot be left blank")
    private String lastName;
    @Email
    @NotNull
    @NotBlank(message = "You must enter a valid email")  //MORE DEFINITION OF PASSWORD SPECS ON THE WEBSITE
    private String email;
    @NotBlank(message = "You must enter a valid password")
    private String password;
    @OneToMany
    @JsonIgnore
    private List<Account> accounts;
    private double rent;
    private double salary;

    public User() {}

    public User(String firstName, String lastName, String email, String password, List<Account> accounts, double rent, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accounts = accounts;
        this.rent = rent;
        this.salary = salary;
    }

    public User(Long id, String firstName, String lastName, String email, String password, List<Account> accounts, double rent, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accounts = accounts;
        this.rent = rent;
        this.salary = salary;
    }

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

   public void setEmail(String email) {
       this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        final String secretKey = "PasswordKey";
        this.password = AES.encrypt(password, secretKey);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rent=" + rent +
                ", salary=" + salary +
                '}';
    }
}

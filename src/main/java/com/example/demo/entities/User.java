package com.example.demo.entities;

import com.example.demo.authentication.EmailValidator;
import javafx.scene.control.PasswordField;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
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

    public String getEmail() {
        return email;
    }

   public void setEmail(String email) {
       if(EmailValidator.validateEmail(email))
        this.email = email;
    }

    public CharSequence getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<? extends Account> getAccounts() {
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

}

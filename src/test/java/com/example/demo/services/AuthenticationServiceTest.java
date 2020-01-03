package com.example.demo.services;

import com.example.demo.authentication.CustomPassWordEncoder;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    User newUser;


    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserRepository userRepository;

@BeforeEach
    void setUp() {

            }

@Test
void createUser() {

//    CustomPassWordEncoder encoder = new CustomPassWordEncoder();
//    newUser = new User ("Don", "Mattingly", "BigDon@yahoo.com", "Donnie123$", null, 1000, 85000);
//    System.out.println(newUser.getPassword());
//
//
//
//
//    String email = "david.trombello@cr.k12.de.us";
//    Iterable<User> users= userRepository.findAll();
//    System.out.println(users);
//    User findMe = userRepository.findById(1L).get();
//    System.out.println(findMe.toString());
//    User user = userRepository.findUserByEmail(email);
//    System.out.println("Find user by Email: " + user.toString());

    }
}
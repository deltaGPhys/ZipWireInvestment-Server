package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AuthenticationServiceTest {
    User newUser;


    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserRepository userRepository;

@BeforeEach
    void setUp() {

            }


}
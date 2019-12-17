package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.entities.Account;
import com.example.demo.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/users")
    public ResponseEntity<Account> createUser(@RequestBody User user) {
        return null;
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Account> modifyUser(@PathVariable long id, @RequestBody User user) {
        return null;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Account> getUser(@PathVariable long id) {
        return null;
    }

    @GetMapping("/logIn")
    public ResponseEntity<Account> logIn(@RequestParam String username, @RequestParam String password) {
        return null;
    }


}

package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.entities.Account;
import com.example.demo.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(authenticationService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers (){
        return new ResponseEntity<>(authenticationService.findAll(), HttpStatus.OK);
    }

//    @PutMapping("/forgot-password")
//    public ResponseEntity<String> forgotPassword(@Re)


//    @GetMapping("/users/{id}")
//    public ResponseEntity<Account> getUser(@PathVariable long id) {
//        return null;
//    }

    @GetMapping("/{email}")
    public ResponseEntity<Account> logIn(@PathVariable String email, @RequestParam String password) {
        return null;
    }


}

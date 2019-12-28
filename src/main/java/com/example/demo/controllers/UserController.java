package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dashboard")
public class UserController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserService userService;


    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser (@Valid @RequestBody User user) {
        return new ResponseEntity<>(authenticationService.update(user), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User owner, Long id){
        return new ResponseEntity<User>(userService.createUser(owner), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User>show(@PathVariable Long id){
        return new ResponseEntity<>(userService.show(id), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Boolean>delete(@PathVariable Long id){
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Iterable<User>> showAll() {
        return new ResponseEntity<>(userService.showAll(), HttpStatus.OK);
    }

}

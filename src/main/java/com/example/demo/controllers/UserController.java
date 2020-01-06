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


    @PutMapping("/user/update/")
    public ResponseEntity<User> updateUser (@Valid @RequestBody User userToUpdate) throws Exception {
        return new ResponseEntity<>(authenticationService.update(userToUpdate), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User>show(@PathVariable Long userId){
        return new ResponseEntity<>(userService.showByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/user/name/{userName}")
    public ResponseEntity<User>show(@PathVariable String userName){
        return new ResponseEntity<>(userService.showUserByUserName(userName), HttpStatus.OK);
    }

    @DeleteMapping("/user/remove/{id}")
    public ResponseEntity<Boolean>delete(@PathVariable Long id){
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Iterable<User>> showAll() {
        return new ResponseEntity<>(userService.showAll(), HttpStatus.OK);
    }

}

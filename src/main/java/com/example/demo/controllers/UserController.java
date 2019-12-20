package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/my-info")
public class UserController {
    @Autowired
    private AuthenticationService authenticationService;

    @PutMapping("/update")
    public ResponseEntity<User> updateUser (@Valid @RequestBody User user) {
        return new ResponseEntity<>(authenticationService.update(user), HttpStatus.OK);
    }

}

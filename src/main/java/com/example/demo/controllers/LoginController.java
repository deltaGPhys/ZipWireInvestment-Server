package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.entities.Account;
import com.example.demo.services.AuthenticationService;
import org.json.JSONException;
import org.json.JSONObject;
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
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(authenticationService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<User> findByUserEmail(@PathVariable String email) {
        try {
            return new ResponseEntity<>(authenticationService.findUserByEmail(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<User> verify (@RequestBody String data) throws Exception {
        JSONObject jsonData = new JSONObject(data);
        String email = (String) jsonData.get("email");
        String password = (String) jsonData.get("password");
        User loggedInUser = authenticationService.verify(email, password);
        return (loggedInUser != null) ? new ResponseEntity<>(loggedInUser, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers (){
        return new ResponseEntity<>(authenticationService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/checkEmail")
    public ResponseEntity<Boolean> checkIfEmailExists(@RequestBody String data) throws JSONException {
        JSONObject jsonData = new JSONObject(data);
        String email = (String) jsonData.get("email");
        return new ResponseEntity<>(authenticationService.emailAvailabilityCheck(email), HttpStatus.OK);
    }

    @GetMapping("/users/id/{id}")
    public ResponseEntity<User> getUserById (@PathVariable long userId) {
        return new ResponseEntity<>(authenticationService.showUser(userId), HttpStatus.OK);
    }


}

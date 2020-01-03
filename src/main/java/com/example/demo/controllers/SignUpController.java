package com.example.demo.controllers;


import com.example.demo.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping
    public String showForm() {
        return "signup";
    }

    @PostMapping
    public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        return "success";
    }

}

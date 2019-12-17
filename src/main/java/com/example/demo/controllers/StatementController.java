package com.example.demo.controllers;

import com.example.demo.entities.reports.Statement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;

@Controller
public class StatementController {



    @GetMapping("/statement/{accountId}")
    public ResponseEntity<Statement> getStatementForAccount(@PathVariable long accountId, @RequestParam Date date) {
        return null;
    }

    @GetMapping("/statement/{userId}")
    public ResponseEntity<Iterable<Statement>> getStatementForUser(@PathVariable long userId, @RequestParam Date date) {
        return null;
    }
}

package com.example.demo.controllers;

import com.example.demo.enums.TransactionType;
import com.example.demo.services.EnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnumController {

    @Autowired
    EnumService enumService;

    @GetMapping("/transactiontypes")
    public ResponseEntity<Iterable<TransactionType>> getTransactionTypes() {
        return new ResponseEntity<>(enumService.getTransactionTypes(), HttpStatus.OK);
    }

}

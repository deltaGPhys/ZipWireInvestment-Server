package com.example.demo.controllers;

import com.example.demo.entities.Investment;
import com.example.demo.entities.investment.Security;
import com.example.demo.entities.investment.SecurityHolding;
import com.example.demo.repositories.SecurityHoldingRepository;
import com.example.demo.repositories.SecurityRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.InvestmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class InvestmentController {

    @Autowired
    InvestmentService investmentService;

    @Autowired
    SecurityRepository securityRepository;

    @Autowired
    SecurityHoldingRepository securityHoldingRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/investment/securities")
    public ResponseEntity<Iterable<Security>> getAllSecurities() {
        return new ResponseEntity<Iterable<Security>>(securityRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/investment/holdings/{accountId}")
    public ResponseEntity<Iterable<SecurityHolding>> getHoldingsForAccount(@PathVariable long accountId) {
        System.out.println(new ResponseEntity<Iterable<SecurityHolding>>(investmentService.getSecurityHoldingsByAccount(accountId), HttpStatus.OK));
        return new ResponseEntity<Iterable<SecurityHolding>>(investmentService.getSecurityHoldingsByAccount(accountId), HttpStatus.OK);
    }

    @PostMapping("/investment/holdings")
    public ResponseEntity<SecurityHolding> buyNewSecurity(@RequestBody String data) throws JSONException {
        JSONObject jsonData = new JSONObject(data);
        return new ResponseEntity<SecurityHolding>(investmentService.buyNewSecurity((int) jsonData.get("accountId"),(int) jsonData.get("securityId"),(double) jsonData.get("numShares")),HttpStatus.CREATED);

    }

    @PutMapping("/investment/holding/{id}")
    public ResponseEntity<Iterable<SecurityHolding>> modifyHoldings(@PathVariable long id, @RequestParam Iterable<Security> securities) {
        return null;
    }

    @GetMapping("/investment/{id}")
    public ResponseEntity<Investment> getInvestmentAccount(@PathVariable long id) {
        return new ResponseEntity<Investment>(investmentService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/investment/user/{userId}")
    public ResponseEntity<Investment> getInvestmentAccountForUser(@PathVariable long userId) {
        return new ResponseEntity<Investment>(investmentService.getForUser(userId), HttpStatus.OK);
    }

    @PostMapping("/investment")
    public ResponseEntity<Investment> createInvestmentAccount(@RequestBody Investment investment) {
        return new ResponseEntity<Investment>(investmentService.createAccount(investment), HttpStatus.CREATED);
    }
}

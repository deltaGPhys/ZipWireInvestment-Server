package com.example.demo.controllers;

import com.example.demo.dto.ReportRequestDto;
import com.example.demo.entities.reports.SpendingReport;
import com.example.demo.services.AccountService;
import com.example.demo.services.SpendTrackerService;
import com.example.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class TrackerController {

    @Autowired
    private SpendTrackerService spendTrackerService;


    @GetMapping("/tracker/account/{accountId}")
    public ResponseEntity<SpendingReport> getReportForAccount(@PathVariable("accountId") long accountId, @RequestBody ReportRequestDto requestDto){

        return spendTrackerService.getReportForAccount(accountId, requestDto);
    }

//    @GetMapping("/tracker/account/{accountId}")
//    public ResponseEntity<SpendingReport> getReportForAccountTimePeriod(@PathVariable long accountId, @RequestParam Date date) {
//        return null;
//    }

//    @GetMapping("/tracker/account/{userId}")
//    public ResponseEntity<SpendingReport> getReportForUserTimePeriod(@PathVariable long userId, @RequestParam Date date) {
//        return null;
//    }
}
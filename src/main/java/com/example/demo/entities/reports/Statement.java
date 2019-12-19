package com.example.demo.entities.reports;

import com.example.demo.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Statement {

    private long id;
    private User user;
    private List<AccountReport> accountReports;

}

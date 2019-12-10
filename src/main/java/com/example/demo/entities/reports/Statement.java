package com.example.demo.entities.reports;

import com.example.demo.entities.User;
import com.example.demo.entities.reports.AccountReport;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class Statement {

    private long id;
    private User user;
    private List<AccountReport> accountReports;

}

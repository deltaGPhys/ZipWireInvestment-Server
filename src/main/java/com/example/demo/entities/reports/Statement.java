package com.example.demo.entities.reports;

import com.example.demo.entities.User;
import com.example.demo.entities.reports.AccountReport;

import javax.persistence.*;
import java.util.List;

@Entity
public class Statement {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<AccountReport> accountReports;

}

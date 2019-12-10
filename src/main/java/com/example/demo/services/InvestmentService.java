package com.example.demo.services;

import com.example.demo.entities.accounts.Investment;
import com.example.demo.repositories.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;


    public InvestmentService(InvestmentRepository investmentRepository) {this.investmentRepository = investmentRepository;}

        public Iterable<Investment> index(){
        return investmentRepository.findAll();

        }















}

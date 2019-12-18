package com.example.demo.services;

import com.example.demo.entities.Investment;
import com.example.demo.repositories.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;


    public InvestmentService(InvestmentRepository investmentRepository) {this.investmentRepository = investmentRepository;}

        public Iterable<Investment> index(){
        return null;
    }

    public Investment get(Long id){return null;}



    public Investment buy(Long id) {return null;}



    public Investment value(Long id) {return null;}














}

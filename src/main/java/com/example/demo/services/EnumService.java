package com.example.demo.services;

import com.example.demo.enums.TransactionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class EnumService {

    public Iterable<TransactionType> getTransactionTypes() {
        TransactionType[] types = TransactionType.values();
        return new ArrayList<TransactionType>(Arrays.asList(types));
    }
}

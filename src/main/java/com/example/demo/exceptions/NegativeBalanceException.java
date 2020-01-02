package com.example.demo.exceptions;

public class NegativeBalanceException extends Exception {

    public NegativeBalanceException() {

    }

    public NegativeBalanceException(String message) {
        super(message);
    }
}

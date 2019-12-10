package com.example.demo.other;

public enum TransactionType {

    FEE ("Fee"),
    TRANSFER ("Transfer"),
    INTEREST_EARNED ("Interest Earned"),
    INVESTMENT_RETURNS ("Investment Returns"),
    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal");

    private String description;

    TransactionType (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

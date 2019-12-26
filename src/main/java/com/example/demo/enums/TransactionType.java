package com.example.demo.enums;

public enum TransactionType {

    FEE (0,"Fee"),
    TRANSFER (1,"Transfer"),
    INTEREST_EARNED (2,"Interest Earned"),
    INVESTMENT_RETURNS (3,"Investment Returns"),
    DEPOSIT(4,"Deposit"),
    WITHDRAWAL(5,"Withdrawal");

    private int id;
    private String description;

    TransactionType (int id, String description) {
        this.description = description;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

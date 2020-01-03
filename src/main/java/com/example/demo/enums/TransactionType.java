package com.example.demo.enums;

import com.example.demo.entities.Transaction;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {

    FEE (0,"Fee"),
    TRANSFER (1,"Transfer"),
    INTEREST_EARNED (2,"Interest Earned"),
    INVESTMENT_RETURNS (3,"Investment Returns"),
    DEPOSIT(4,"Deposit"),
    WITHDRAWAL(5,"Withdrawal"),
    SECURITY_PURCHASED(6, "Security Purchased"),
    SECURITY_LIQUIDATED(7,"Security Liquidated"),
    POS_PURCHASE(8, "Point-of-Sale Purchase");

    private int id;
    private String description;

    TransactionType (int id, String description) {
        this.description = description;
        this.id = id;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public static TransactionType fromName(String name) {
        for (TransactionType t : TransactionType.values()) {
            if (t.description.equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

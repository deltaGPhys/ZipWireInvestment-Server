package com.example.demo.other;

public enum SpendingCategories {

    ENTERTAINMENT("Entertainment"),
    FOOD_AND_DRINK("Food and Drink"),
    TRAVEL("Travel"),
    HOUSING("Housing"),
    UTILITIES("Utilities")
    ;

    private String description;

    SpendingCategories(String description) {
        this.description = description;
    }
}

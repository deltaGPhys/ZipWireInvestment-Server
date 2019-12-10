package com.example.demo.enums;


public enum Merchant {
    WAWA("Wawa",SpendingCategories.FOOD_AND_DRINK,1.00,20.00),
    CINEMARK("Cinemark Cinemas",SpendingCategories.ENTERTAINMENT,12.00,50.00);


    private String name;
    private SpendingCategories category;
    private double minCharge;
    private double maxCharge;

    Merchant(String name, SpendingCategories category, double minCharge, double maxCharge) {
        this.name = name;
        this.category = category;
        this.minCharge = minCharge;
        this.maxCharge = maxCharge;
    }

    public String getName() {
        return name;
    }


    public SpendingCategories getCategory() {
        return category;
    }


    public double getMinCharge() {
        return minCharge;
    }


    public double getMaxCharge() {
        return maxCharge;
    }
}

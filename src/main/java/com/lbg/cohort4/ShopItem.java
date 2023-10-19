package com.lbg.cohort4;

public class ShopItem {
    private final double itemPrice;
    private final double quantity;

    public ShopItem(double itemPrice, int quantity){
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }
    public double calculateCost(double taxRate){
        return (itemPrice * quantity) + (itemPrice * quantity * taxRate);
    }
}

package com.lbg.cohort4;

public class Main{
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.addItems();
        System.out.println(shop.shopSum());
    }
}
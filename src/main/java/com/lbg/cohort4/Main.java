package com.lbg.cohort4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{


    public static void main(String[] args) {

        ArrayList<ShopItem> itemPrices = new ArrayList<>();
        Scanner mainScanner = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Please enter each item's price, followed by the return key.");

        int iteration = 1;
        while(!quit){

            itemPrices.add(new ShopItem(
                    getDoubleValue(String.format("Item %d Price (£): ", iteration),
                    "Please Enter a Numerical Value: "),
                    getIntValue("Please enter a quantity: ",
                            "Please Enter a Numerical Value:")));

            System.out.print("Type 'quit' to exit and save or any other key to continue: ");
            if(mainScanner.next().equalsIgnoreCase("quit")){
                quit = true;
            }
        }

        double vat;
        do {
            vat = getDoubleValue("Please Enter a VAT Rate Between 0 and 100(%): ",
                    "Please Enter a Numerical Value Between 0 and 100: ");
        }while(!(vat >= 0 && vat <= 100));


        System.out.println("Your total cost for these items (price + VAT) is: " + sum(itemPrices, vat/100));

    }
    public static double calculateVAT(double price, double vat){
        return price + (price * vat/100);
    }

    // Method implementing error checking to assert String can be parsed to double.
    public static double getDoubleValue(String initialMessage, String errorMessage) {
        Scanner scan = new Scanner(System.in);
        boolean success = false;
        System.out.print(initialMessage);
        double doubleValue = 0;
        while (!success) {
            try {
                doubleValue = Double.parseDouble(scan.next());
                success = true;
            } catch (Exception e) {
                System.out.print(errorMessage);
            }
        }
        return doubleValue;
    }

    public static int getIntValue(String initialMessage, String errorMessage) {
        Scanner scan = new Scanner(System.in);
        boolean success = false;
        System.out.print(initialMessage);
        int intValue = 0;
        while (!success) {
            try {
                intValue = Integer.parseInt(scan.next());
                success = true;
            } catch (Exception e) {
                System.out.print(errorMessage);
            }
        }
        return intValue;
    }
    public static double sum(ArrayList<ShopItem> items, double taxRate){
        double sum = 0;
        for (ShopItem item : items)
            sum += item.calculateTotalCost(taxRate);
        return sum;
    }
}
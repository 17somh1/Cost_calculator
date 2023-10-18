package com.lbg.cohort4;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many items would you like to add to your basket?: ");

        // Try catch inside while loop to ensure program does not break after invalid inputs.
        boolean priceSuccess = false;
        System.out.print("Please Enter Price (£): ");
        double price = 0;
        while(!priceSuccess) {
            try {
                price = Double.parseDouble(scan.next());
                priceSuccess = true;
            } catch (Exception e) {
                System.out.print("Input cannot be parsed - please enter a numerical value: ");
            }
        }

        // Similar logic for error checking for VAT.
        boolean vatSuccess = false;
        System.out.print("Please Enter VAT Rate (%): ");
        double vat = 0;
        while(!vatSuccess) {
            try {
                vat = Double.parseDouble(scan.next());
            } catch (Exception e) {
                System.out.print("Input cannot be parsed - please enter a numerical value: ");
            }
            if (vat >= 0 && vat <= 100){
                vatSuccess = true;
            }else {
                System.out.print("Value needs to be between 0 and 100: ");
            }
        }

        System.out.println("Your total cost for this item (price + VAT) is " + calculateVAT(price, vat));

    }
    public static double calculateVAT(double price, double vat){
        return price + (price * vat/100);
    }

    // Method implementing error checking to assert String can be parsed to double.
    public static boolean assertDouble(String doubleStr){
        boolean success = false;
        return false;
    }


}
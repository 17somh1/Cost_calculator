package com.lbg.cohort4;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many items would you like to add to your basket?: ");

        double price = getDoubleValue("Please Enter Price (£): ",
                "Please Enter a Numerical Value: ");

        double vat = 0;

        do {
            vat = getDoubleValue("Please Enter a VAT Rate Between 0 and 100(%): ",
                    "Please Enter a Numerical Value Between 0 and 100: ");
        }while(!(vat >= 0 && vat <= 100));

        System.out.println("Your total cost for this item (price + VAT) is " + calculateVAT(price, vat));

    }
    public static double calculateVAT(double price, double vat){
        return price + (price * vat/100);
    }

    // Method implementing error checking to assert String can be parsed to double.
    public static double getDoubleValue(String initialMessage, String errorMessage){
        Scanner scan = new Scanner(System.in);
        boolean success = false;
        System.out.print(initialMessage);
        double doubleValue = 0;
        while(!success) {
            try {
                doubleValue = Double.parseDouble(scan.next());
                success = true;
            } catch (Exception e) {
                System.out.print(errorMessage);
            }
        }
        return doubleValue;
    }


}
package com.lbg.cohort4;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop implements UserIO{
    private ArrayList<ShopItem> itemPrices = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);

    public Shop(){}
    public void addItems(){
        int iteration = 1;
        boolean quit = false;

        System.out.println("Please enter each item's price, followed by the return key.");
        while(!quit){
            itemPrices.add(new ShopItem(
                    getDoubleValue(String.format("Item %d Price (£): ", iteration),
                            "Please Enter a Numerical Value: "),
                    getIntValue("Please enter a quantity: ",
                            "Please Enter a Numerical Value > 0:")));

            System.out.print("Type 'quit' to exit and save or any other key to continue: ");
            if(scan.next().equalsIgnoreCase("quit")){
                quit = true;
            }
        }
    }
    private double getVat(){
        double vat;
        do {
            vat = getDoubleValue("Please Enter a VAT Rate Between 0 and 100(%): ",
                    "Please Enter a Numerical Value Between 0 and 100: ");
        }while(!(vat >= 0 && vat <= 100));
        return vat/100;
    }
    private double getDoubleValue(String initialMessage, String errorMessage) {
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

    private int getIntValue(String initialMessage, String errorMessage) {
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
        return Math.max(intValue, 0);

    }
    public double shopSum(){
        double vat = getVat();
        double sum = 0;
        for (ShopItem item : itemPrices)
            sum += item.calculateCost(vat);
        return sum;
    }



}

package com.lbg.cohort4;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        String promptReturn;
       do{
           promptReturn = prompt();
           System.out.println(promptReturn);
       }while (promptReturn != null);
       TestClass.testInt = 0;
    }
    private static String prompt(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an input: ");
        return scan.next();
    }


}
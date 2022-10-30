package com.example.chapter26;

import java.util.Scanner;

/**
 * Dividing two numbers with some exception handling
 *
 * @author leosun
 */
public class Exceptions {

    public static void main(String[] args) {
        String input;

        double quotient = 0;
        int numerator = 0;
        int denominator = 0;

        try ( Scanner myScanner = new Scanner(System.in)) {
            try {
                System.out.println("Please enter the numerator: ");
                input = myScanner.nextLine();
                numerator = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("You didn't enter a number for numerator!");
            }

            try {
                System.out.println("Please enter the denominator: ");
                input = myScanner.nextLine();
                denominator = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("You didn't enter a number for denominator!");
            }

            try {
                quotient = numerator / denominator;
            } catch (ArithmeticException ex) {
                System.out.println("Something went wrong: " + ex);
            } finally {
                System.out.println("finally code block for quotient");
            }
            
            System.out.println("The quotient is: " + quotient);
        } 
    }
}

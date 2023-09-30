package com.company;

import java.util.Scanner;

public class TryWithResources {

    public static void main(String [] args) {

        // Using try-with-resources to automatically close the Scanner
        try (Scanner SC = new Scanner(System.in)) {
            System.out.println("Enter A: ");
            // Read an integer from the user's input
            int a = Integer.valueOf(SC.nextLine());

            System.out.println("Enter B: ");
            // Read another integer from the user's input
            int b = Integer.valueOf(SC.nextLine());

            // Perform the division operation
            int c = a / b;

            // Display the result of the division
            System.out.println("Division = " + c);
        } catch (ArithmeticException e) {
            // Handle the case where the divisor is 0
            System.out.println("Divisor must be greater than 0 ");
        }

        // This line is executed after the try block, even if there was an exception
        System.out.println("Finishing Program");
    }
}

package com.company;

import java.util.Scanner;

public class ArithmeticExceptionFixed {

    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner SC = new Scanner(System.in);

        try {
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
        } finally {
            // Close the Scanner in the 'finally' block to ensure it's always closed
            SC.close();
            // This block always executes, whether an exception occurred or not
            System.out.println("I always execute in the 'finally' block");
        }

        // This line is executed after the try-catch-finally block
        System.out.println("Finishing Program");
    }
}

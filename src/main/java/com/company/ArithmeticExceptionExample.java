package com.company;

import java.util.Scanner;

public class ArithmeticExceptionExample {

    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner SC = new Scanner(System.in);

        System.out.println("Enter A: ");
        // Read an integer from the user's input
        int a = Integer.valueOf(SC.nextLine());

        System.out.println("Enter B: ");
        // Read another integer from the user's input
        int b = Integer.valueOf(SC.nextLine());

        // Perform the division operation
        // Note: This code does not handle the case where 'b' is 0
        int c = a / b;

        // Display the result of the division
        System.out.println("Division = " + c);

        // If 'b' is 0, this code will throw an ArithmeticException
        // because dividing by zero is undefined in mathematics
    }
}

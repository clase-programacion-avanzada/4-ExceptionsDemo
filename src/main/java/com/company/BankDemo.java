package com.company;

import com.company.exception.InsufficientFundsException;
import com.company.model.BankAccount;

import java.util.Scanner;

public class BankDemo {

    public static final String YES = "y";

    public static void main(String[] args) {
        // We have two accounts, one is 'c' and the other is 'c2'. 'c2' is what we don't want to do in code
        BankAccount c = new BankAccount();
        //Reference: https://www.geeksforgeeks.org/understanding-null-pointer-exception-in-java/
        //Reference: https://stackoverflow.com/questions/218384/what-is-a-nullpointerexception-and-how-do-i-fix-it
        BankAccount c2 = null;

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        boolean userWantsToContinue = false;

        do {
            // Display a welcome message and menu
            System.out.println("""
                    Welcome to the bank
                    Select the operation you want to perform today
                    1. Deposit
                    2. Withdraw
                    """);

            // Call the selectOperation method to handle user's choice
            selectOperation(scanner, c);

            // Ask if the user wants to perform another operation
            System.out.println("Do you want to perform another operation? (y/n)");
            userWantsToContinue = scanner.nextLine().equalsIgnoreCase(YES);

        } while (userWantsToContinue);

        try {
            // This will throw a NullPointerException intentionally
            c2.withdraw(200);

        } catch (NullPointerException e) {
            // Handle the NullPointerException and print a message
            System.out.println("You have a null pointer exception");
            e.printStackTrace();

        } catch (InsufficientFundsException e) { // This catch is mandatory
            throw new RuntimeException(e);
        } finally {
            // This block will always execute, regardless of exceptions
            System.out.println("Finishing program");
        }

        // Close the scanner
        scanner.close();
    }

    // Method to handle the user's selected operation
    private static void selectOperation(Scanner scanner, BankAccount c) {
        try {
            Integer option = Integer.valueOf(scanner.nextLine());

            switch (option) {
                case 1 -> deposit(scanner, c);
                case 2 -> withdraw(scanner, c);
                default -> System.out.println("Unsupported Operation");
            }

        } catch (NumberFormatException e) {
            // Handle the case where the user didn't enter a valid number
            System.out.println("Option must be a number");
        } finally {
            // This block will always execute, returning to the main menu
            System.out.println("Returning to the main menu");
        }
    }

    // Method to handle a withdrawal operation
    private static void withdraw(Scanner scanner, BankAccount c) {

        //Reference: https://www.geeksforgeeks.org/try-catch-throw-and-throws-in-java/
        //Reference: https://www.javatpoint.com/try-catch-block
        //Reference: https://www.programiz.com/java-programming/try-catch
        try {
            System.out.println("Write the amount to withdraw from account: ");
            Double amountToWithdraw = getAmount(scanner, "Withdraw");

            // Attempt to withdraw the specified amount from the account
            c.withdraw(amountToWithdraw);

            // Display the current balance
            System.out.println("Current balance: " + c.getBalance());

        } catch (InsufficientFundsException e) {
            // Handle the case where there are insufficient funds for withdrawal
            System.out.println("Sorry, but you are short $"
                + e.getAmount()
                + " to withdraw");
        //Reference: https://www.tutorialspoint.com/how-to-solve-an-illegalargumentexception-in-java
        } catch (IllegalArgumentException e) {
            // Handle the case where an illegal argument exception occurred
            System.out.println(e.getMessage());
        }
    }

    // Method to get a valid amount from the user
    private static Double getAmount(Scanner scanner, String operation) {
        Double amount = 0D;

        do {
            try {
                Double amountToWithdraw = Double.valueOf(scanner.nextLine());

                return amountToWithdraw;
            //Reference https://www.geeksforgeeks.org/numberformatexception-in-java-with-examples/
            } catch (NumberFormatException e) {
                // Handle the case where the user didn't enter a valid number
                System.out.println(operation + " amount must be a number");
                System.out.println("Write again the amount: ");
            }
        } while (true);
    }

    // Method to handle a deposit operation
    private static void deposit(Scanner scanner, BankAccount c) {
        System.out.println("Write the amount to deposit to account: ");
        Double amountToDeposit = getAmount(scanner, "Deposit");

        // Deposit the specified amount into the account
        c.deposit(amountToDeposit);

        // Display the current balance
        System.out.println("Current balance: " + c.getBalance());
    }
}

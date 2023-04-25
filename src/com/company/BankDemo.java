package com.company;

import com.company.exception.InsufficientFundsException;
import com.company.model.BankAccount;

import java.util.Scanner;

public class BankDemo{

    public static void main(String [] args) {

        /* We have two accounts, one is c and the other is c2. c2 is what we don't want to do in code*/
        BankAccount c = new BankAccount();
        BankAccount c2 = null;
        //BankAccount c3 = new BankAccount(-100);


        Scanner scanner = new Scanner(System.in);

        boolean userWantsToContinue = false;

        do {

            System.out.println("Select the operation you want to perform today");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");

            selectOperation(scanner, c);

            System.out.println("Do you want to perform another operation? (y/n)");
            userWantsToContinue = scanner.nextLine().equalsIgnoreCase("y");

        } while (userWantsToContinue);


        try{
            /*This will throw NullPointerException*/
            c2.withdraw(200);

        } catch (NullPointerException e) {
            System.out.println("You have a null pointer exception");
            e.printStackTrace();

        } catch (InsufficientFundsException e) { //This catch is mandatory
            throw new RuntimeException(e);
        } finally {
            System.out.println("Finishing program");
        }

        scanner.close();
    }

    private static void selectOperation(Scanner scanner, BankAccount c) {

        try {

            Integer option = Integer.valueOf(scanner.nextLine());

            switch (option) {
                case 1 -> deposit(scanner,c);
                case 2 -> withdraw(scanner,c);
                default -> System.out.println("Unsupported Operation");
            }

        } catch (NumberFormatException e) {
            System.out.println("Option must be a number");
        }  finally {
            System.out.println("Returning to the main menu");
        }
    }

    private static void withdraw(Scanner scanner, BankAccount c) {

        try {
            System.out.println("Write the amount to withdraw from account: ");
            Double amountToWithdraw = getAmount(scanner, "Withdraw");

            c.withdraw(amountToWithdraw);

            System.out.println("Current balance: " + c.getBalance());

        } catch (InsufficientFundsException e) {
            System.out.println("Sorry, but you are short $"
                    + e.getAmount()
                    + " to withdraw");
            //e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Double getAmount(Scanner scanner, String operation) {
        Double amount = 0D;

        do {
            try {
                Double amountToWithdraw =
                    Double.valueOf(scanner.nextLine());

                return amountToWithdraw;

            } catch (NumberFormatException e) {
                System.out.println(operation + " amount must be a number");
                System.out.println("Write again the amount : ");

            }
        } while (true);
    }

    private static void deposit(Scanner scanner, BankAccount c){


        System.out.println("Write the amount to deposit to account: ");
        Double amountToDeposit = getAmount(scanner, "Deposit");

        c.deposit(amountToDeposit);

        System.out.println("Current balance: " + c.getBalance());


    }
}

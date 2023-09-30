package com.company.model;

import com.company.exception.InsufficientFundsException;

import java.util.IllegalFormatException;

// BankAccount class represents a bank account with deposit, withdraw, and balance operations.

public class BankAccount {

    // Constants for minimum amounts and error message template
    private static final Double MINIMUM_AMOUNT_TO_WITHDRAW = 10D;
    private static final Double MINIMUM_INITIAL_BALANCE = 0D;
    private static final String INVALID_BALANCE_OR_AMOUNT_MSG_TEMPLATE =
        /* Reference: https://www.java67.com/2014/06/how-to-format-float-or-double-number-java-example.html */
        "Number provided for %s must be a number greater than %.0f";

    // Static variable to keep track of the next available account ID
    private static Integer nextId = 1;
    private double balance;
    private int id;

    // Default constructor
    public BankAccount() {
        // Assign a unique ID to the account
        this.id = nextId++;
    }

    // Constructor with initial balance
    public BankAccount(double initialBalance) throws IllegalArgumentException {

        // Check if the initial balance is less than the minimum allowed
        boolean isInvalidInitialBalance =
            initialBalance < MINIMUM_INITIAL_BALANCE;

        if (isInvalidInitialBalance) {
            // Create an error message using String.format
            /* Reference: https://www.javatpoint.com/java-string-format
             * Reference: https://www.baeldung.com/string/format */
            String exceptionMessage =
                String.format(INVALID_BALANCE_OR_AMOUNT_MSG_TEMPLATE,
                    "Initial Balance",
                    MINIMUM_INITIAL_BALANCE);
            // Throw an IllegalArgumentException with the error message
            throw new IllegalArgumentException(exceptionMessage);
        }

        // Assign a unique ID to the account
        this.id = nextId++;
        this.balance = initialBalance;
    }

    // Deposit method to add money to the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdraw method to remove money from the account
    public void withdraw(double amount)
        throws InsufficientFundsException, IllegalArgumentException {

        // Check if the amount to withdraw is less than the minimum allowed
        boolean isInvalidAmount = amount <= MINIMUM_AMOUNT_TO_WITHDRAW;

        if (isInvalidAmount) {
            // Create an error message using String.format
            /* Reference: https://www.javatpoint.com/java-string-format
             * Reference: https://www.baeldung.com/string/format */
            String exceptionMessage =
                String.format(INVALID_BALANCE_OR_AMOUNT_MSG_TEMPLATE,
                    "Withdraw",
                    MINIMUM_AMOUNT_TO_WITHDRAW);
            // Throw an IllegalArgumentException with the error message
            //Reference: https://www.geeksforgeeks.org/throw-throws-java/
            //Reference: https://www.javatpoint.com/throws-keyword-in-java
            //Reference: https://www.baeldung.com/java-throw-exception
            throw new IllegalArgumentException(exceptionMessage);
        }

        // Check if there is insufficient balance for the withdrawal
        boolean isInsufficientMoneyForWithdraw = amount >= balance;

        if (isInsufficientMoneyForWithdraw) {
            double neededMoneyForTransaction = amount - balance;
            // Throw an InsufficientFundsException with the needed amount
            throw new InsufficientFundsException(neededMoneyForTransaction);
        }
        balance -= amount;
    }

    // Getter method to retrieve the account balance
    public double getBalance() {
        return balance;
    }

    // Getter method to retrieve the account ID
    public int getId() {
        return id;
    }
}

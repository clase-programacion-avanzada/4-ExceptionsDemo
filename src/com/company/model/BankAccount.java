package com.company.model;

import com.company.exception.InsufficientFundsException;

import java.util.IllegalFormatException;

public class BankAccount {

    private static final Double MINIMUM_AMOUNT_TO_WITHDRAW = 10D;
    private static final Double MINIMUM_INITIAL_BALANCE = 0D;
    private static final String INVALID_BALANCE_OR_AMOUNT_MSG_TEMPLATE =
            /*https://www.java67.com/2014/06/how-to-format-float-or-double-number-java-example.html*/
            "Number provided for %s must be a number greater than %.0f";

    private static Integer nextId = 1;
    private double balance;
    private int id;



    public BankAccount() {
        this.id = nextId++;
    }

    public BankAccount(double initialBalance) throws IllegalArgumentException {

        boolean isInvalidInitialBalance =
                initialBalance < MINIMUM_INITIAL_BALANCE;

        if (isInvalidInitialBalance) {
            String exceptionMessage =
                    /*https://www.javatpoint.com/java-string-format
                     *https://www.baeldung.com/string/format */
                    String.format(INVALID_BALANCE_OR_AMOUNT_MSG_TEMPLATE,
                            "Initial Balance",
                            MINIMUM_INITIAL_BALANCE);
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.id = nextId++;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {

        balance += amount;
    }



    public void withdraw(double amount)
            throws InsufficientFundsException,
                IllegalArgumentException {

        boolean isInvalidAmount = amount <= MINIMUM_AMOUNT_TO_WITHDRAW;

        if (isInvalidAmount) {
            String exceptionMessage =
                    /*https://www.javatpoint.com/java-string-format
                     *https://www.baeldung.com/string/format*/
                    String.format(INVALID_BALANCE_OR_AMOUNT_MSG_TEMPLATE,
                            "Withdraw",
                            MINIMUM_AMOUNT_TO_WITHDRAW);
            throw new IllegalArgumentException(exceptionMessage);
        }

        boolean isInsufficientMoneyForWithdraw = amount >= balance;
        if (isInsufficientMoneyForWithdraw) {
            double neededMoneyForTransaction = amount - balance;
            throw new InsufficientFundsException(neededMoneyForTransaction);
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

}
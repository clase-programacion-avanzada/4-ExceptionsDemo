package com.company.exception;

// Custom Exception Class: InsufficientFundsException
// This class is used to create a custom exception for situations
// where there are insufficient funds in an account.
//Reference: https://www.baeldung.com/java-new-custom-exception
//Reference: https://www.geeksforgeeks.org/user-defined-custom-exception-in-java/
//Reference: https://www.javatpoint.com/custom-exception
public class InsufficientFundsException extends Exception {
    // Create a private instance variable to store the amount that triggered the exception.
    private double amount;

    // Constructor for InsufficientFundsException
    // This constructor is called when the exception is thrown and allows
    // us to provide information about the amount that triggered the exception.
    public InsufficientFundsException(double amount) {
        // Initialize the 'amount' instance variable with the value passed to the constructor.
        this.amount = amount;
    }

    // Getter method for the 'amount' instance variable.
    // This method allows other parts of the code to retrieve the amount that
    // caused the exception to be thrown.
    public double getAmount() {
        return amount;
    }
}

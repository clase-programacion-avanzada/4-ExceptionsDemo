package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ErrorExample {

    public static void main(String[] args) {
        // Create a list to store integers
        List<Integer> list = new ArrayList<>();

        // Create a Random object for generating random numbers
        Random random = new Random();

        while (true) {
            // Add a random integer to the list
            list.add(random.nextInt());

            // This loop will run indefinitely, adding integers to the list
            // Eventually, it may lead to an OutOfMemoryError
            // as the list grows beyond the available memory
        }
    }
}

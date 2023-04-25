package com.company;

import java.util.Scanner;

public class TryWithResources {

    public static void main(String [] args) {

        try (Scanner SC = new Scanner(System.in)){
            System.out.println("Enter A: ");
            int a = Integer.valueOf(SC.nextLine());
            System.out.println("Enter B: ");
            int b = Integer.valueOf(SC.nextLine());
            int c = a/b;
            System.out.println("Division = "+ c);
        } catch (ArithmeticException e) {
            System.out.println("Divisor must be greater than 0 ");
        }
        System.out.println("Finishing Program");

    }
}

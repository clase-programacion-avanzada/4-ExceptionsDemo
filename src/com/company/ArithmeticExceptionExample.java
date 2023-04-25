package com.company;

import java.util.Scanner;

public class ArithmeticExceptionExample  {

    public static void main(String [] args) {
        Scanner SC = new Scanner(System.in);

        System.out.println("Enter A: ");
        int a = Integer.valueOf(SC.nextLine());
        System.out.println("Enter B: ");
        int b = Integer.valueOf(SC.nextLine());
        int c = a/b;

        System.out.println("Division = "+ c);
    }
}

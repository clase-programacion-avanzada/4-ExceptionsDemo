package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ErrorExample {

    public static void main(String [] args) {

        List<Integer> list = new ArrayList<>();

        Random random = new Random();

        while(true) {
            list.add(random.nextInt());
        }

    }
}

package com.allan;

public class FleaChaseRabbit {

    public static void main(String[] args) {

        double sum = 0;
        long milesToInch = 1601 * 40;
        long count = 2;

        do {
            System.out.println(" n = " + count + "; sum = " + sum ) ;
            sum += (double) 1 / count++;

        }
        while ( sum < milesToInch);
        System.out.println(" n = " + count + "; sum = " + sum ) ;
    }
}


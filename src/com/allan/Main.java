package com.allan;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello");


        int maxInt = 1000;
        double area = 1;

        for ( int i = 0 ; i < maxInt ; i ++){
            area = (double)area - Math.pow((double)2, i)*((double)1/(double)3)*Math.pow((double)1/(double)9, i);
            System.out.println("area = " + area);
        }

    }
}

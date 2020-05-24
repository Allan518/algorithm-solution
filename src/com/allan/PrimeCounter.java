package com.allan;

public class PrimeCounter {

    static public int countPrime( int input){

        int count = 0;
        boolean[] primeBook = new boolean[input];
        for( int i = 2 ; i <= input; i ++) {
            if ( ! primeBook[i-1] ){
                count++;
                System.out.print(i + " ");
                for( int j = 2 ; j*i <= input; j++ ){
                    primeBook[j*i -1 ] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 1000000;
        long x = System.currentTimeMillis();
        System.out.println("total number of primes = " + PrimeCounter.countPrime(n));
        long y = System.currentTimeMillis();
        System.out.println("total time spent for " +  n  + " is " + (y-x));
    }
}

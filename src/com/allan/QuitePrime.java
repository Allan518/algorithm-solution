package com.allan;

public class QuitePrime {

    private static boolean isQuitePrime ( long inNumber){
        boolean result = false;
        if ( inNumber % 2 != 0 &&
                inNumber % 3 != 0 &&
                inNumber % 5 != 0 ){
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }

    private static boolean isVeryPrime ( long inNumber){
        boolean result = false;
        if ( inNumber % 2 != 0 &&
                inNumber % 3 != 0 &&
                inNumber % 5 != 0 &&
                inNumber % 7 != 0 &&
                inNumber % 11 != 0 &&
                inNumber % 13 != 0
                ){
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        long maxInt = 9000;
        long count = 0;
        long lastcount = 0;
        long test = 3;
        long remainder = 0;
        long result = 0;

        for ( int i = 1; i <= 27; i ++){
            remainder = test% 100;
            result = test/100;

           // System.out.println("3 ^ " + i + " = " + test + " = " + result + " R " + remainder );
            test *= 3;
        }

        for ( long i = 2; i < maxInt; i ++){
            if ( isVeryPrime(i)){
                System.out.println(i);
                lastcount++;
            }
//            if ( isVeryPrime(i)){
//                System.out.print(i + " ");
//                count ++;
//            }
            if ( i%10 == 0 ){
                //System.out.println();
            }
           // System.out.println("total number of QuitePrime is " + lastcount + " out of " + i);
        }
        System.out.println("total number of QuitePrime is " + lastcount + " out of " + maxInt);
    }
}

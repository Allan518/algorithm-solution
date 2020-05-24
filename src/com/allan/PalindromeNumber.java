package com.allan;

public class PalindromeNumber {

    static boolean isPalindrome(int input ){
        int mod = 1;
        while( input/mod > 10 ) {
            mod =  mod * 10;
        }
        while ( input > 0 ){
            int left = input / mod;
            int right = input % 10;
            if ( left != right){
                return false;
            }
            input = ( input % mod )/10;
            mod = mod / 100;

        }
        return true;
    }

    public static void main(String[] args) {
        int x = 12321;
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        System.out.println( x + " is " +  ( isPalindrome(x) ? "":"not " ) + "a palindromeNumber.");
    }
}

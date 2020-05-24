package com.allan;

import java.util.Arrays;

public class ReverseInteger {

    public int reverseInt(int input ){
        int res = 0;
        while( input > 0 ){
            if ( res > Integer.MAX_VALUE/10 ) {
                res = -1;
                break;
            }
            res = res * 10 +  input %10;
            input = input/10;
        }
        return res;
    }

    public static void main(String[] args) {
        int inInt = 2147483312;
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverseInteger.reverseInt(inInt));

    }
}

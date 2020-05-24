package com.allan;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInteger(String roman){
        int result = 0;
        Map<String, Integer> romanMap = new HashMap();
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);

        for( int i = 0; i < roman.length(); i++){
            String thisChar = String.valueOf(roman.charAt(i));
            int thisDigit = romanMap.get(thisChar);
            if ( i == roman.length() -1 || thisDigit >= romanMap.get(String.valueOf(roman.charAt(i + 1)))){     // >=; >
                result += thisDigit;
            }
            else{
                result -= thisDigit;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        String roman = "MCDXIV";
        roman = "MMIV";
        System.out.println("The value of " + roman + " is " + romanToInteger.romanToInteger(roman));
    }

}

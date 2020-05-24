package com.allan;

import java.util.Arrays;

public class LongestCommonPrefix {

    static String getLongestCommonPrefix(String[] inStrs){
        String result = "";
        for( int i = 0 ; i < inStrs[0].length() ; i++ ){
            char c = inStrs[0].charAt(i);
            for ( int j = 1; j < inStrs.length ; j ++){
                if ( inStrs[j].length() <= result.length()
                        || inStrs[j].charAt(i) != c                        ){
                    return result;
                }

            }
            result += Character.toString(c);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"hello", "held", "hell", ""};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        System.out.println("The longest common prefix for " + Arrays.toString(strings) + " is " + longestCommonPrefix.getLongestCommonPrefix(strings));
    }
}

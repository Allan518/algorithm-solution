package com.allan;

import java.util.Map;
import java.util.HashMap;

public class PatternMatcher {

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }


    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "hello yes yes hello"));
    }
}
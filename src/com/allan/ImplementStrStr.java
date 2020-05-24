package com.allan;

public class ImplementStrStr {
    static int strStr(String bigStr, String smallStr) {
        if (bigStr.isEmpty()) return 0;

        int m = bigStr.length();
        int n = smallStr.length();

        if (m < n) return -1;

        for (int i = 0; i < m - n; i++) {
            int j = 0;
            for (j = 0; j < n; j++) {
                if (bigStr.charAt(i + j) != smallStr.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "isitpossibleforyoutoworklate";
        String b = "";

        System.out.println(strStr(a, b));
    }

}



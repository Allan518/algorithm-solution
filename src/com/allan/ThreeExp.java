package com.allan;

public class ThreeExp {

    static long myPower(long x, long y) {
        long result = x;
        for (int i = 1; i <= y - 1; i++) {
            result *= x;
            System.out.println("3^" + (i + 1) + " =" + result);

        }
        return result;
    }


    static long myPowerMod(long x, long y) {
        long result = x;
        for (int i = 1; i <= y - 1; i++) {
            result *= x;
            result %= 10000000000l;
            System.out.println("3^" + (i + 1) + " =" + result);

        }
        return result;
    }

    public static void main(String[] args) {
        long x33 = myPower(3, 3);
        long x333 = myPowerMod(3, x33);
        //long x3333 = myPowerMod(3, x333);
    }
}

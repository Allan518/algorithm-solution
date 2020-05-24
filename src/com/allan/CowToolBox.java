package com.allan;

public class CowToolBox {

    static int getIntegerLength(int number) {
        if (number < 100000)

        {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else

        {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }

    static int firstDigit(int x) {
        while (x > 9) {
            x /= 10;
        }
        return x;
    }

    public static void main(String[] args) {
        int a = 123456789;
        int COUNT = 1000000;
        long a1 = System.currentTimeMillis();
        int digit;
        int j = 2;
        j *= 7 - 4;
        System.out.println(" j = " + j);
        for (int i = 0; i < COUNT; i++) {
            digit = Integer.parseInt(Integer.toString(a).substring(0, 1));
        }

        long a2 = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            digit = firstDigit(i);
        }

        long a3 = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            digit = String.valueOf(a).charAt(0) - '0';
        }


        long a4 = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            int length = (int) (Math.log10(a) + 1);
        }

        long a5 = System.currentTimeMillis();
        System.out.println(a2 - a1);
        System.out.println(a3 - a2);
        System.out.println(a4 - a3);
        System.out.println(a5 - a4);



























    }
}

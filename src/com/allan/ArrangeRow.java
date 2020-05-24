package com.allan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrangeRow {
    public static boolean distinctValues(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isGoodOrder(int[] top, int[] bottom) {
        boolean result = false;
        if (top[4] > top[3] && top[3] > top[2] && top[2] > top[1] && top[1] > top[0]
                && bottom[5] > bottom[4] && bottom[4] > bottom[3] && bottom[3] > bottom[2] && bottom[2] > bottom[1]
                && top[1] > bottom[1]
                && top[2] > bottom[2]
                && top[3] > bottom[3]
                && top[4] > bottom[4]
                && top[5] > bottom[5]) {
            result = true;
            System.out.println("top " + Arrays.toString(top));
            System.out.println("bot " + Arrays.toString(bottom));

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] bottom = new int[6];
        int[] top = new int[6];
        int count = 0;
        bottom[0] = 1;
        top[5] = 12;
        for (int i = 2; i <= 11; i++) {
            for (int j = 2; j <= 11; j++) {
                for (int k = 2; k <= 11; k++) {
                    for (int l = 2; l <= 11; l++) {
                        for (int m = 2; m <= 11; m++) {
                            for (int p = 2; p <= 11; p++) {
                                for (int q = 2; q <= 11; q++) {
                                    for (int r = 2; r <= 11; r++) {
                                        for (int s = 2; s <= 11; s++) {
                                            for (int t = 2; t <= 11; t++) {
                                                top[0] = i;
                                                top[1] = j;
                                                top[2] = k;
                                                top[3] = l;
                                                top[4] = m;
                                                bottom[1] = p;
                                                bottom[2] = q;
                                                bottom[3] = r;
                                                bottom[4] = s;
                                                bottom[5] = t;
                                                int[] arr = {top[0], top[1], top[2], top[3], top[4], top[5], bottom[1], bottom[2], bottom[3], bottom[4], bottom[5]};
                                                if (distinctValues(arr)) {

                                                    if (isGoodOrder(top, bottom)) {
                                                        System.out.println("good");
                                                        count++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("total " + count);
    }
}

package com.allan;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
    static int removeDuplicate(int[] input){
        int i = 0;
        for( int num : input){
            System.out.print(num + " ");
            if ( i == 0 || num > input[i-1]){
                input[i++] = num;
            }
        }
        System.out.println();
        return i;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3 , 4 , 5, 5 , 5 , 6 };
        System.out.println(removeDuplicate(a));
        System.out.println(Arrays.toString(a));
    }

}



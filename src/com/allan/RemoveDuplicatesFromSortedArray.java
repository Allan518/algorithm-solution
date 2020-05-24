package com.allan;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    static int removeDuplicates(int[] input){
        int slow = 0;
        if( input.length == 0) return 0;
        for( int fast = 1; fast < input.length; fast ++){
            if( input[slow] != input[fast]){
                input[++slow] = input[fast];
            }
        }
        return slow + 1;
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4, 5, 6};
        System.out.println(removeDuplicates(numbers));
        System.out.println(Arrays.toString(numbers));
    }
}

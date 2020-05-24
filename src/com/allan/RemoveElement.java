package com.allan;

public class RemoveElement {
    static int removeElement(int[] input, int val){
        int i = 0;
        for( int num : input){
            if( num != val){
                input[i++] = num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 2, 3 , 3, 4, 4, 5 };
        System.out.println(removeElement(ints, 2));
    }

}


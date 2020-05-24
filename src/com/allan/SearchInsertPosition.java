package com.allan;

import java.time.Duration;
import java.time.Instant;

public class SearchInsertPosition {

    static int insertPosition(int[] ints, int target) {
        int result = 0;
        for (int i : ints) {
            if (target <= i) {
                break;
            } else {
                result++;
            }
        }
        System.out.println("easy steps = " + result);
        return result;
    }

    static int insertPositionBinary(int[] ints, int target) {
        int left = 0;
        int right = ints.length ;
        int mid = 0;
        while( left < right ){
            mid =  ( right + left )/2;
            if( target > ints[mid] ){
                left = mid + 1 ;
            }else{
                right = mid ;
            }
        }
        return right;
    }

    public static void main(String[] args) {
       // int[] ints = {1, 2, 3, 4, 5, 6, 10, 20, 30, 40, 50};
        int sizeOfArray = 1_000_000_00;
        int[] ints = new int[sizeOfArray];
        for ( int i = 0 ; i < ints.length; i ++ ){
            ints[i] = i;
        }
        int target = 500_000_00;
        Instant starting = Instant.now();
        System.out.println(insertPosition(ints, target));
        Instant easyFinishing = Instant.now();

        long timeElapsedEasy = Duration.between(starting, easyFinishing).toMillis();
        System.out.println(insertPositionBinary(ints, target));
        Instant binaryFinishing = Instant.now();
        long timeElapsedBinary = Duration.between(easyFinishing, binaryFinishing).toMillis();
        System.out.println("Time spent easy:\t" + timeElapsedEasy);
        System.out.println("Time spent binary:\t"  + timeElapsedBinary);


    }
}

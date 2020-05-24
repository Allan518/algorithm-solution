package com.allan;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target ){
        int[] result = new int[2];
        HashMap<Integer, Integer > hashMap = new HashMap<>();
        for ( int i = nums.length - 1 ; i >=0  ; i--){
            int t = target - nums[i];
            if( hashMap.containsKey(t) && hashMap.get(t) != i)
            {
                result[0] = i;
                result[1] = hashMap.get(t);
                break;
            }
            else{
                hashMap.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = {2, 14, 5, 6, 7, 9, 10, 3};
        int target = 18;

        System.out.println( Arrays.toString(twoSum.twoSum(ints, target)));
    }
}

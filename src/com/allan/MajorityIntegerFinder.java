package com.allan;

import java.util.Arrays;

public class MajorityIntegerFinder {
    public int getMajorityInteger(int[] theArray) {
        Arrays.sort(theArray);
        int frequentValue = 0;
        int frequentValueCount = 1;
        int nextFrequentValueCount = 0;
        for (int i = 0; i < theArray.length - 1; i++) {
            if (theArray[i] == theArray[i + 1]) {
                frequentValueCount++;
            } else {
                nextFrequentValueCount++;
                if (nextFrequentValueCount > frequentValueCount) {
                    frequentValueCount = nextFrequentValueCount;
                    frequentValue = i;
                }
            }
        }
        return theArray[frequentValue];
    }//1, 2, 2, 2, 3, 3, 4, 5, 7, 9
    public static void main(String[] args) {

        int[] theArray = {1, 5, 9, 7, 2, 2, 2, 1, 3, 3, 3, 3, 3, 4};
        MajorityIntegerFinder findMajority = new MajorityIntegerFinder();
        System.out.println(findMajority.getMajorityInteger(theArray));
    }
}
package com.allan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CowEscapeFarm {
    static int[] cowWeightArray;
    static int maxCowsCountsUnderWeight = 0;

    static boolean checkNoCarrier(int x, int y) {
        for (; x > 0 && y > 0; x /= 10, y /= 10) {
            if (x % 10 + y % 10 > 9) {
                return false;
            }
        }
        return true;
    }

    static void weightSum(String cowListBinary) {
        int weight = 0;
        int cows = 0;
        for (int i = 0; i < cowListBinary.length(); i++) {
            if (cowListBinary.charAt(i) == '1') {
                if (checkNoCarrier(weight, cowWeightArray[cowListBinary.length() - i - 1])) {
                    weight += cowWeightArray[cowListBinary.length() - i - 1];
                    cows++;
                }
                else{
                    return;
                }
            }
        }
        if (cows > maxCowsCountsUnderWeight) {
            maxCowsCountsUnderWeight = cows;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
        System.out.println(Integer.toString(z, 3));
        */
        BufferedReader br = new BufferedReader(new FileReader("escape.in"));
        int totalCows = Integer.parseInt(br.readLine());
        cowWeightArray = new int[totalCows];
        for (int i = 0; i < totalCows; i++) {
            cowWeightArray[i] = Integer.parseInt(br.readLine());
        }
        PrintWriter pw = new PrintWriter(new FileWriter("escape.out"));
        String cowListBinaryString;
        for (int i = 0; i < Math.pow(2, totalCows); i++) {
            cowListBinaryString = Integer.toBinaryString(i);
            weightSum(cowListBinaryString);
        }
        System.out.println(maxCowsCountsUnderWeight);
        pw.println((maxCowsCountsUnderWeight));
        pw.flush();


    }
}

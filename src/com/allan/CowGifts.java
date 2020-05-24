package com.allan;

import java.io.*;
import java.util.StringTokenizer;

public class CowGifts {

    static int totalCows;
    static int totalBudget;
    static int[] giftPrice;
    static int[] shippingPrice;


    static void sortCost() {
        boolean done = false;
        while( !done) {
            done = true;
            for (int i = 0; i < totalCows - 1; i++) {
                int tmp = 0;
                if (giftPrice[i] + shippingPrice[i] > giftPrice[i + 1] + shippingPrice[i + 1]) {
                    tmp = giftPrice[i];
                    giftPrice[i] = giftPrice[i + 1];
                    giftPrice[i + 1] = tmp;
                    tmp = shippingPrice[i];
                    shippingPrice[i] = shippingPrice[i + 1];
                    shippingPrice[i + 1] = tmp;
                    done = false;
                }
            }
        }
    }

    static int getMaximumCowsWithGifts(int couponCow) {
        int budget = totalBudget - giftPrice[couponCow] / 2 - shippingPrice[couponCow];
        if( budget < 0 ) return 0;
        int i = 0;
        int maxCows = 0;
        do {
            if (i != couponCow ) {
                budget =  budget - giftPrice[i] - shippingPrice[i];
                if (budget >= 0) {
                    maxCows++;
                }
            }
            i++;
        }
        while (budget > 0 && i < totalCows);
        return maxCows + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("gifts.in"));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        totalCows = Integer.parseInt(stringTokenizer.nextToken());
        totalBudget = Integer.parseInt(stringTokenizer.nextToken());

        giftPrice = new int[totalCows];
        shippingPrice = new int[totalCows];

        for (int i = 0; i < totalCows; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            giftPrice[i] = Integer.parseInt(stringTokenizer.nextToken());
            shippingPrice[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        sortCost();

        int maxGiftCounts = 0;
        int tmp;
        for (int i = 0; i < totalCows; i++) {
            tmp = getMaximumCowsWithGifts(i);
            if (tmp > maxGiftCounts) {
                maxGiftCounts = tmp;
            }
        }

        PrintWriter pw = new PrintWriter( new BufferedWriter(new FileWriter("gifts.out")));
        pw.println(maxGiftCounts);
        System.out.println(maxGiftCounts);
        pw.flush();
    }
}

package com.allan;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CowStacking {

    static int totalStack = 0;
    static int totalInstructions = 0;
    static int[] diff;
    public static int i(String s) { return Integer.parseInt(s); }

    public static void main(String[] args) throws Exception{
        BufferedReader bf =  new BufferedReader(new FileReader("stacking.in"));

        StringTokenizer stringTokenizer  = new StringTokenizer(bf.readLine());
        totalStack = Integer.parseInt(stringTokenizer.nextToken());
        totalInstructions  = Integer.parseInt(stringTokenizer.nextToken());

        diff = new int[totalStack + 1];
        for( int i = 0; i < totalInstructions; i++){
            stringTokenizer = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            diff[start -1 ]++;
            diff[end]--;
        }

        int val = 0;
        int[] data = new int[totalStack];
        for( int i = 0; i < totalStack ; i++){
            val += diff[i];
            data[i] = val;
        }
        Arrays.sort(data);
        System.out.println(data[( totalStack + 1 )/2]);

        PrintWriter pw = new PrintWriter(new BufferedWriter( new FileWriter("stacking.out")));
        pw.println(data[( totalStack + 1 )/2]);
        pw.flush();
    }
}

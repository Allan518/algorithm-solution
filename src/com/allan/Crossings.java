package com.allan;

import java.util.*;
import java.io.*;
import java.awt.Point;
import static java.lang.Math.*;

public class Crossings {
    public static int i(String s) { return Integer.parseInt(s); }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("crossings.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new
                FileWriter("crossings.out")));
        int n = i(in.readLine());
        int[][] P = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] arr = in.readLine().split(" ");

            P[i] = new int[]{i(arr[0]), i(arr[1])};
        }
        Arrays.sort(P, new Comparator<int[]>() {
            public int compare(int[] A, int[] B) {
                return A[0]-B[0];
            }
        });

        int[] maxl = new int[n];
        maxl[0] = P[0][1];
        for(int i=1; i<n; i++)
            maxl[i] = Math.max(maxl[i-1], P[i][1]);

        int[] minr = new int[n];
        minr[n-1] = P[n-1][1];
        for(int i=n-2; i>=0; i--)
            minr[i] = Math.min(minr[i+1], P[i][1]);

        int safe = 0;
        for(int i=0; i<n; i++) {
            boolean ok = true;
            if(i!=0 && maxl[i-1] > P[i][1]) ok = false;
            if(i!=n-1 && minr[i+1] < P[i][1]) ok = false;
            if(ok) safe++;
        }
        out.println(safe);
        out.flush();
    }
}
/*
-3 4
7 8
10 16
3 9
 */
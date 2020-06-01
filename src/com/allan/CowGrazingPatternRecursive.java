package com.allan;

import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.FileHandler;

public class CowGrazingPatternRecursive {
    static int[][] matrix = new int[5][5];
    static int totalBarren;

    static int getCount(int x, int y){
        System.out.println("start   " + x + "," + y + ". totalBarren = " + totalBarren);
        int count =0;
        if( x< 0 || y < 0 || x > 4 || y > 4 ||  matrix[x][y] == 1) return 0;
        matrix[x][y] = 1;
        totalBarren++;
        if( totalBarren == 25 && x == 4 && y == 4) {
            count = 1;
        }
        else {
            count = getCount(x-1, y) + getCount(x, y-1 ) + getCount(x+1, y) + getCount(x, y+1);
        }
        matrix[x][y] = 0;
        totalBarren--;
        System.out.println("end     " + x + "," + y + ". totalBarren = " + totalBarren);
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new FileReader("grazing.in"));

        totalBarren = Integer.parseInt(bf.readLine() );
        for( int i = 0 ; i < totalBarren; i++ ){
            StringTokenizer stringTokenizer = new StringTokenizer( bf.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            matrix[x -1][y -1] = 1;
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("grazing.out")));
        int x = getCount(0,0);
        System.out.println(x);
        pw.println(x);
        pw.flush();

    }
}

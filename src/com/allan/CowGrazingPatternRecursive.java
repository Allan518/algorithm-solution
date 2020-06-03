package com.allan;

import java.io.*;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.logging.FileHandler;

public class CowGrazingPatternRecursive {
    static int SIZE = 5;
    static int[][] matrix = new int[SIZE][SIZE];
    static int totalBarren;

    static int getCount(int x, int y){
        //System.out.print(" start   " + x + "," + y +  " - uid " +  ",  totalBarren = " + totalBarren);
        int count =0;
        if( x< 0 || y < 0 || x > SIZE -1  || y > SIZE -1  ||  matrix[x][y] == 1) return 0;
        matrix[x][y] = 1;
        totalBarren++;
        System.out.println( x + "," + y + " now totalBarren = " + totalBarren);
        if( totalBarren == SIZE*SIZE && x == SIZE -1  && y == SIZE -1 ) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!! ending point");
            count = 1;
        }
        else {
            count = getCount(x-1, y) + getCount(x, y-1 ) + getCount(x+1, y) + getCount(x, y+1);
        }
        matrix[x][y] = 0;
        totalBarren--;
        System.out.println( x + "," + y +  " end totalBarren = " + totalBarren + " count = " + count);
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
        System.out.println();
        System.out.println("total = " + x);
        pw.println(x);
        pw.flush();

    }
}

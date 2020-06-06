
/*
ID: 100021881
LANG: JAVA
PROG: numtri
https://jvonk.github.io/usaco/2018/10/04/numtri.html
*/

import java.io.*;
import java.util.*;

public class MaxNumberTriangles {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N+1][N+1];
        int[][] results = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int j = 0; line.hasMoreTokens(); j++) {
                triangle[i][j] = Integer.parseInt(line.nextToken());
                results[i][j] = -1;
            }
        }
        out.println(findLongest(triangle, 0, 0, results, N));
        br.close();
        out.close();
    }

    public static int findLongest(int[][] triangle, int i, int j, int[][] results, int N) {
        System.out.print("inside " + i+ " "+ j + " ");
        if(results[i][j]!=-1) {
            System.out.println("normal " + i + "," + j + " is " + results[i][j] );
            return results[i][j];
        } else if (i<=triangle.length) {
            results[i][j]=triangle[i][j]+Math.max(findLongest(triangle, i+1, j, results, N), findLongest(triangle, i+1, j+1, results, N));
            System.out.println("recursive " + i + "," + j + " is " + results[i][j] );
            return results[i][j];
        } else {
            System.out.println("zero " + i + "," + j + " is " + results[i][j] );
            return 0;
        }
    }
}

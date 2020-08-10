import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class GrandFarmOff {//L?

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N, a, b, c, d, e, f, g, h, M;
        N = Integer.parseInt(stringTokenizer.nextToken());
        a = Integer.parseInt(stringTokenizer.nextToken());
        b = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());
        d = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());
        f = Integer.parseInt(stringTokenizer.nextToken());
        g = Integer.parseInt(stringTokenizer.nextToken());
        h = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        long[][] cowMatrix = new long[N * 3][2];
        for (int i = 0; i < 3 * N; i++) {
            cowMatrix[i][0] = (a * valueAfterMod(i, 5, d) + b * valueAfterMod(i, 2, d) + c) % d;
            cowMatrix[i][1] = (e * valueAfterMod(i, 5, h) + f * valueAfterMod(i, 3, d) + g) % h;
        }
        //Arrays.sort(cowMatrix, Comparator.comparingLong(ar -> ar[1]));
        Arrays.sort(cowMatrix, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if( o1[1] < o2[1] || ( o1[1] == o2[1] && o1[0] > o2[0])){
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        long result = 0;
        for( int i = 0 ; i < N; i++){
            result += cowMatrix[i][0];
        }
        System.out.println(result%M);

    }

    static long valueAfterMod(long cowIndex, long powerNumber, long modNumber) {
        long result = 1;
        for (int i = 1; i <= powerNumber; i++) {
            result = (result * cowIndex) % modNumber;
        }
        return result;
    }


}

/*
The Grand Farm-off
==================

Farmer John owns 3*N (1 <= N <= 500,000) cows surprisingly numbered
0..3*N-1, each of which has some associated integer weight W_i (1 <=
W_i <= d). He is entering the Grand Farm-off, a farming competition
where he shows off his cows to the greater agricultural community.

This competition allows him to enter a group of N cows. He has given
each of his cows a utility rating U_i (1 <= U_i <= h), which
represents the usefulness he thinks that a particular cow will have
in the competition, and he wants his selection of cows to have the
maximal sum of utility.

There might be multiple sets of N cows that attain the maximum
utility sum. FJ is afraid the competition may impose a total weight
limit on the cows in the competition, so a secondary priority is
to bring lighter weight competition cows.

Help FJ find a set of N cows with minimum possible total weight
among the sets of N cows that maximize the utility, and print the
remainder when this total weight is divided by M (10,000,000 <= M
<= 1,000,000,000).

Note: to make the input phase faster, FJ has derived polynomials
which will generate the weights and utility values for each cow.
For each cow 0 <= i < 3*N,

       W_i = (a*i^5+b*i^2+c) mod d
 and   U_i = (e*i^5+f*i^3+g) mod h

with reasonable ranges for the coefficients (0 <= a <= 1,000,000,000;
0 <= b <= 1,000,000,000; 0 <= c <= 1,000,000,000; 0 <= e <=
1,000,000,000; 0 <= f <= 1,000,000,000; 0 <= g <= 1,000,000,000;
10,000,000 <= d <= 1,000,000,000; 10,000,000 <= h <= 1,000,000,000).

The formulae do sometimes generate duplicate numbers; your algorithm
should handle this properly.

PROBLEM NAME: farmoff

INPUT FORMAT:

* Line 1: Ten space-separated integers: N, a, b, c, d, e, f, g, h, and M

SAMPLE INPUT:

2 0 1 5 55555555 0 1 0 55555555 55555555

INPUT DETAILS:

The functions generate weights of 5, 6, 9, 14, 21, and 30 along
with utilities of 0, 1, 8, 27, 64, and 125.

OUTPUT FORMAT:

* Line 1: A single integer representing the lowest sum of the weights
        (modulo M) of the N cows with the highest net utility.

SAMPLE OUTPUT:

51

OUTPUT DETAILS:

The two cows with the highest utility are cow 5 and 6, and their combined
weight is 21+30=51.
 */
import java.util.Scanner;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumbers = scanner.nextInt();

        int[] numbers = new int[totalNumbers];
        for( int i = 0; i < totalNumbers; i++){
            numbers[i] = scanner.nextInt();
        }
        int[] result = new int[totalNumbers];
        result[0] = 1;
        int maxSequence = 0;
        for( int i = 1; i < totalNumbers; i++){
            int currentMax = 1;
            for( int j = 0; j < i ; j++){
                if( numbers[j] < numbers[i] ){
                    currentMax = Math.max(result[j] + 1, currentMax);
                }
            }
            result[i] = currentMax;
            maxSequence = Math.max(currentMax, maxSequence);
        }
        System.out.println(maxSequence);
    }
}
/*
Longest Increasing Subsequence
==============================

Given a sequence of N numbers (0 < N <= 20,000) find the size of
the longest increasing subsequence.

PROBLEM NAME: lis

INPUT FORMAT:

* Line 1: One integer, N

* Line 2...N+1: Numbers in the sequence

SAMPLE INPUT:

12
4
2
1
3
7
4
2
9
11
6
8
4

OUTPUT FORMAT:

* Line 1: Single integer that is the size of the longest increasing
          subsequence

SAMPLE OUTPUT:
5

OUTPUT DETAILS:

The longest increasing subsequence is 2 3 4 6 8.
1 3 4 6 8 is another one.
Answer:(penalty regime: 0 %)
Language
java

 */
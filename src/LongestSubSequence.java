import java.util.Scanner;

public class LongestSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int num = sc.nextInt();
        int[] count = new int[num];
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        count[0] = 1;
        for (int i = 1; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    count[i] = Math.max(count[i], count[j]);
                }
            }
            count[i]++;
            answer = Math.max(answer, count[i]);
        }
        System.out.println(answer);
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
 */
package com.allan;

public class ConnectCows {
    static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    static void printArray(int[] input) {
        System.out.print('\n');
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
    }

    public static int  printAllRecursive(
            int n, int[] elements, int delimiter) {

        if(n == 1) {
            printArray(elements);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements, delimiter);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements, delimiter);
        }
        return 1;
    }

    public static void main(String[] args) {


    }

}

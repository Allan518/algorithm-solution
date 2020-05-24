package com.allan;

public class ConsistentPlayerCombination {
    static boolean isBetter(int i, int j, int[] thisMatch) {
        boolean result = false;
        int ipos = 0;
        int jpos = 0;
        for(int m = 0; m < thisMatch.length; m ++){
            if(thisMatch[m] == i ){
                ipos = m;
            }
            else if ( thisMatch[m] == j){
                jpos = m;
            }
        }
        if ( ipos < jpos ){
            result = true;
        }
        return result;
    }

    static int totalBetter(int i, int j, int[][] matchResults) {
        int result = 0;
        for( int m = 0 ; m < matchResults.length; m++){
            if( isBetter(i, j, matchResults[m])){
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int totalPlayers = 4;
        int totalSessions = 3;
        /*
        4 1 2 3
        4 1 3 2
        4 2 1 3
        */
        int[][] matchResults = {{4, 1, 2, 3}, {4, 1, 3, 2}, {4, 2, 1, 3}};
        int result = 0;

        for (int i = 1; i <= totalPlayers; i++) {
            for (int j = 1; j <= totalPlayers; j++) {
                if( i != j && totalBetter(i, j, matchResults) == totalSessions ){
                    System.out.println(" " + i + ", " + j );
                    result++;
                }
            }
        }
        System.out.println("total combination = " + result) ;
    }
}

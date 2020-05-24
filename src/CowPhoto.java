import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

public class CowPhoto {

    static int[][] posMatrix;
    static int[] cowRanks;

    static void compareTwoCows(int cow1 , int cow2  ){
        int cow1FrontCount = 0;
        for ( int i = 0; i < 5; i++ ){
            if ( posMatrix[i][cow1] < posMatrix[i][cow2]){
                cow1FrontCount++;
            }
        }
        if( cow1FrontCount > 2 ){
            cowRanks[cow2]++;
        }
        else{
            cowRanks[cow1]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new FileReader("photo.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("photo.out"));

        int totalCows = Integer.parseInt(bf.readLine());
        posMatrix = new int[5][totalCows];

        cowRanks = new int[totalCows];

        int thisCowNumber = 0;
        for( int i = 0 ; i < 5; i ++){
            for( int j = 0 ; j < totalCows; j++ ){
                thisCowNumber = Integer.parseInt(bf.readLine());
                posMatrix[i][thisCowNumber - 1] = j;
            }
        }

        for( int i = 0 ; i < totalCows; i++){
            for ( int j = i+ 1 ; j < totalCows ; j++){
                compareTwoCows( i, j );
            }
        }

        TreeMap<Integer, Integer> cowRankTree= new TreeMap<>();
        for( int i = 0; i < totalCows; i++){
            cowRankTree.put(cowRanks[i], i);
        }
        Collection<Integer> cowIndexes = cowRankTree.values();
        for(Integer cowIndex: cowIndexes){
            System.out.println(cowIndex + 1);
            pw.println(cowIndex + 1);
        }
        pw.flush();


    }
}

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

import static java.lang.System.exit;

public class CowEvolution {
    static int N;
    static Set<String> allSets;
    static String[] allArray;
    static String[][] inputString;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("evolution.in"));
        N = Integer.parseInt(bufferedReader.readLine());
        inputString = new String[N][];

        StringTokenizer stringTokenizer;
        Map<Integer, List<String>> hashMap = new HashMap<>();
        allSets = new HashSet<>();
        for( int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int count = Integer.parseInt( stringTokenizer.nextToken() );
            inputString[i] = new String[ count + 1];
            for( int j = 0; j < count; j++){
                inputString[i][j+1] = stringTokenizer.nextToken();
                allSets.add(inputString[i][j+1]);
            }
        }

        int uniqueSets = allSets.size();
        allArray = new String[uniqueSets];
        allSets.toArray(allArray);

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
        boolean result = true;
        for( int i = 0; i < uniqueSets; i++){
            for( int j = 1; j< uniqueSets && j != i; j++){
                if( isCrossed(i, j)){
                    result = false;
                    printWriter.println("no");
                    System.out.println("no");
                    printWriter.flush();
                    exit(0);
                }
            }
        }
        printWriter.println("yes");
        System.out.println("yes");
        printWriter.flush();
    }


    static boolean isCrossed(int a, int b){
        int A = 0, B= 0, AB = 0;
        for( int i = 0; i < N; i++){
            boolean hasA = false, hasB = false;
            for( int j = 1; j < inputString[i].length; j++ ){
                if( allArray[a].equals(inputString[i][j])){
                    hasA = true;
                }
                if( allArray[b].equals(inputString[i][j])){
                    hasB = true;
                }
            }
            if( hasA && hasB ) AB++;
            else if( hasA ) A++;
            else if( hasB ) B++;
        }
        return AB> 0 && A> 0 && B>0;
    }
}

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class TeamTicTacToe {

    static int N = 0;
    static String[][] matrix = new String[3][3];
    static Set<String> singleVictory = new HashSet<>();
    static Set<String> doubleVictory = new HashSet<>();
    public static void main(String[] args) throws Exception {

        String fileName = "tttt";
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        for (int i = 0; i < 3; i++) {
            String thisRow = bufferedReader.readLine();
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = thisRow.substring(j, j+1);
            }
        }
        Set<String> downCrossSet = new HashSet<>();
        Set<String> upCrossSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            Set<String> rowSet = new HashSet<>();
            Set<String> colSet = new HashSet<>();
            for (int j = 0; j < 3 ; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            processSet(rowSet);
            processSet(colSet);

            downCrossSet.add(matrix[i][i]);
            upCrossSet.add(matrix[i][2-i]);
        }

        processSet(downCrossSet);
        processSet(upCrossSet);
        System.out.println(singleVictory.size());
        System.out.println(doubleVictory.size());

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(singleVictory.size());
        printWriter.println(doubleVictory.size());
        printWriter.flush();
    }

    static void processSet(Set<String> rowSet){
        Iterator it = rowSet.iterator();
        if( rowSet.size() == 1){
            singleVictory.add((String)it.next());
        }
        else if( rowSet.size() == 2){
            String a = (String)it.next();
            String b = (String)it.next();
            if( a.compareTo(b) > 0 ) {
                doubleVictory.add( a + b);
            }
            else{
                doubleVictory.add( b + a);
            }
        }
    }


}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CowBeauty {
    HashSet<Integer> hashSet = new HashSet<>();
    static int[][] dataMatrix;
    static int[][] spotMatrix;
    static int rows = 0;
    static int columns = 0;
    static int group = 0;
    static HashSet<Integer> firstSpotSet;

    static void getExpandedSpot(int i, int j, int group) {
//        System.out.println("starting getExpandedSpot " + i + ", " + j);
        if (dataMatrix[i][j] == 0) {
            return;
        }
        dataMatrix[i][j] = 0;
        spotMatrix[i][j] = group;
        System.out.println("setSpot (" + i + ", " + j + ") as " + group);
        if (i > 0) getExpandedSpot(i - 1, j, group);
        if (j > 0) getExpandedSpot(i, j - 1, group);
        if (i < rows - 1) getExpandedSpot(i + 1, j, group);
        if (j < columns - 1) getExpandedSpot(i, j + 1, group);

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("pageant.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        columns = Integer.parseInt(st.nextToken());

        String[] dataSet = new String[rows];
        dataMatrix = new int[rows][columns];
        spotMatrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            dataSet[i] = br.readLine();
            for (int j = 0; j < columns; j++) {
                dataMatrix[i][j] = ('X' == dataSet[i].charAt(j)) ? 1 : 0;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if( dataMatrix[i][j] == 1) {
                    getExpandedSpot(i, j, ++group);
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        int thisDistance = 0;
        for( int i = 0; i < rows; i++ ){
            for ( int j = 0 ; j < columns; j ++ ){
                if ( spotMatrix[i][j] == 1){
                    for( int m = 0; m < rows; m++){
                        for( int n= 0; n < columns; n++){
                            if( spotMatrix[m][n] == 2 ){
                                thisDistance = Math.abs( m - i ) + Math.abs(n-j ) -1;
                                if( minDistance > thisDistance){
                                    minDistance = thisDistance;
                                }
                            }
                        }
                    }
                }
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("pageant.out"));
        pw.println(minDistance);
        System.out.println(minDistance);
        pw.flush();
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowHopscothL {
    static int rows ;
    static int cols;
    static int uniqueK;
    static int[][] matrix;
    static long[][] stepMatrix;
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        rows = Integer.parseInt(stringTokenizer.nextToken());
        cols = Integer.parseInt(stringTokenizer.nextToken());
        uniqueK = Integer.parseInt(stringTokenizer.nextToken());
        matrix = new int[rows][cols];
        stepMatrix = new long[rows][cols];

        for( int i = 0; i < rows; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for( int j = 0; j < cols; j++){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        System.out.println(getTotalSteps(rows-1, cols -1)% 1000000007);
    }

    static long getTotalSteps(int r, int c ){
        if( r ==0 && c == 0 ){
            stepMatrix[r][c] = 1;
        }
        else if( stepMatrix[r][c] == 0 ){
            for( int i = 0; i < r ; i++){
                for( int j = 0; j < c  ; j++){
                    if( matrix[r][c] != matrix[i][j] ) {
                        long addon = getTotalSteps(i, j);
                        if( addon < 0 ) {
                            addon = 0;
                        }
                        stepMatrix[r][c] +=  addon ;
                    }
                }
            }

        }
        return stepMatrix[r][c] % 1000000007 ;
    }
}

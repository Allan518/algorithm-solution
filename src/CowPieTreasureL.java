import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowPieTreasureL {
    static int rows;
    static int cols;
    static int[][] matrix;
    static int[][] maxGoldArray;
    public static void main(String[] args) throws  Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        rows = Integer.parseInt(stringTokenizer.nextToken());
        cols = Integer.parseInt(stringTokenizer.nextToken());

        matrix = new int[rows + 2 ][cols];
        maxGoldArray = new int[rows + 2][cols];
        for( int i = 1; i <= rows ; i ++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for( int j = 0; j < cols; j++ ){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if ( i-1 > j ){
                    matrix[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        long start = System.currentTimeMillis();
        System.out.println(getMaxGold(rows, cols -1 ));
    }

    static int getMaxGold(int i, int j){
        if(maxGoldArray[i][j] != 0 ){   // if change != to > , performance horrible; but if use > 0 || < 0, the performance is good, not sure why yet
            return maxGoldArray[i][j];
        }
        int result = 0;
        if ( j > 0 ) {
            if ( i >=1 && i <= rows ) {
                result = Integer.MIN_VALUE;
                if ( i < rows ) {
                    result = Math.max(result, getMaxGold( i+1, j-1));
                }
                if (i > 1) {
                    result = Math.max( result, getMaxGold(i-1, j-1));
                }
                result = Math.max(result, getMaxGold(i, j-1));
                result += matrix[i][j];
           }
        }
        else {
            result = matrix[i][j];
        }
        maxGoldArray[i][j] = result;
        return result;
    }
}





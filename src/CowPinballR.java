import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowPinballR {
    static int[][] matrix;
    static int[][] resultArray;
    static int level;

    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        level = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[level][level];
        resultArray = new int[level][level];
        for( int i = 0 ; i < level ; i ++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for( int j = 0; j < level; j++){
                if( j <= i ){
                    matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
        }
        System.out.println(getMaximumSum(0,0));
        long end = System.currentTimeMillis();
        //System.out.println("total time spent is " + ( end - start) + " ms");
    }

    static int getMaximumSum( int i, int j ){
            System.out.println("calling :        " + i + "," + j );
        if( resultArray[i][j] != 0 ){
            System.out.println("return directly: " + i + "," + j );
            return resultArray[i][j];
        }
        int result = 0;
        if( i < level -1 ) {
            result = matrix[i][j] + Math.max(getMaximumSum(i+1, j), getMaximumSum(i+1, j+1));
        }
        else{
            result = matrix[i][j];
        }
        resultArray[i][j] = result;
        return result;
    }
}

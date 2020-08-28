import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowPinballR {
    static int[][] matrix;
    static int level;

    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        level = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[level][level];

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
        System.out.println("total time spent is " + ( end - start) + " ms");

    }

    static int getMaximumSum( int i, int j ){
        int result = 0;
        if( i < level -1 ) {
            result = matrix[i][j] + Math.max(getMaximumSum(i+1, j), getMaximumSum(i+1, j+1));
        }
        else{
            return matrix[i][j];
        }
        return result;
    }
}

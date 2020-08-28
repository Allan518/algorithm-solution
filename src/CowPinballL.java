import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class CowPinballL {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int level = Integer.parseInt(bufferedReader.readLine());
        int[][] matrix = new int[level + 1 ][level + 1];

        for( int i = 0 ; i < level ; i ++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for( int j = 0; j < level; j++){
                if( j <= i ){
                    matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
        }

        for( int i = level -1 ; i >= 0; i--){
            for( int j = 0; j < level; j ++){
                matrix[i][j] =  matrix[i][j] + Math.max( matrix[i+1][j], matrix[i+1][j+1]);
            }
        }
        System.out.println(matrix[0][0]);
    }
}

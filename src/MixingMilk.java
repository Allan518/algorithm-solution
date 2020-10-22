import java.io.*;
import java.util.StringTokenizer;

public class MixingMilk {

    static int N = 0;
    static int[][] matrix = new int[3][2];

    public static void main(String[] args) throws Exception {

        String fileName = "mixmilk";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        for (int i = 0; i < 3 ; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            matrix[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            matrix[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        pour(100);

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(matrix[0][1]);
        printWriter.println(matrix[1][1]);
        printWriter.println(matrix[2][1]);
        printWriter.flush();
    }

    static void pour( int counter){
        int j = 0;
        int k = 0;
        int thisPour = 0;
        for (int i = 0; i < counter ; i++) {
            j = i % 3;
            k = (i+1) % 3;
            thisPour = Math.min( matrix[k][0] - matrix[k][1], matrix[j][1] );
            matrix[j][1] = matrix[j][1]  - thisPour;
            matrix[k][1] = matrix[k][1]  + thisPour;
        }
    }
}

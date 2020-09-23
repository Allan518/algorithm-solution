import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SocialDistBronze2 {
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("socdist2.in"));
        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer;
        matrix = new int[N][2];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            matrix[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            matrix[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(matrix, Comparator.comparingInt(arr -> arr[0]));

        int maxGapWithoutInfection = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            if (matrix[i + 1][1] != matrix[i][1]) {
                maxGapWithoutInfection = Math.min(maxGapWithoutInfection, matrix[i + 1][0] - matrix[i][0]);
            }
        }
        int initialCowsInfected = 0;
        int previousInfectedCowPosition = -maxGapWithoutInfection -1;
        for (int i = 0; i < N; i++) {
            if (matrix[i][1] == 1) {
                if (matrix[i][0] - previousInfectedCowPosition >= maxGapWithoutInfection) {
                    initialCowsInfected++;
                }
                previousInfectedCowPosition = matrix[i][0];
            }
        }
        PrintWriter printWriter = new PrintWriter(new FileWriter("socdist2.out"));
        printWriter.println(initialCowsInfected);
        printWriter.flush();
    }
}

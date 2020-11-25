import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class LearningByExample {
    static int nCows = 0;
    static int A;
    static int B;
    static int[][] matrix;
    //todo

    public static void main(String[] args) throws Exception {
        String fileName = "learning";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        nCows = Integer.parseInt(stringTokenizer.nextToken());
        A = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());

        matrix = new int[nCows + 2][2];
        matrix[0][0] = -2_000_000_999;
        for (int i = 1; i <= nCows; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            matrix[i][1] = 2 - (stringTokenizer.nextToken()).length();
            matrix[i][0] = Integer.parseInt(stringTokenizer.nextToken());
        }
        matrix[nCows + 1][0] = 2_000_000_999;

        Arrays.sort(matrix, Comparator.comparingInt(arr -> arr[0]));

        int spotCowsCounts = 0;
        for (int i = 0; i < matrix.length; i++) {
            spotCowsCounts += countSpotedCow(matrix[i][0], matrix[i + 1][0]);
        }
        System.out.println(spotCowsCounts);


        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(spotCowsCounts);
        printWriter.flush();
    }

    static int countSpotedCow(int start, int end) {
        int result = 0;
        if (end < A) {
            //pass
        } else if (A > start && B < end) {
            int mid =(  start + end )/2;

        } else if (B < start) {

        } else if (start > A && end < B) {

        } else if (start < A && end > A && end < B) {

        } else if (A < start && start < B && B < end) {

        }

        return result;
    }
}

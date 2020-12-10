import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BreedAssignment {//recursive
    static int nCows = 0;
    static int kRelations;
    static int[][] matrix;
    static int[] breedArray;

    public static void main(String[] args) throws Exception {
        String fileName = "assign";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        nCows = Integer.parseInt(stringTokenizer.nextToken());
        kRelations = Integer.parseInt(stringTokenizer.nextToken());

        matrix = new int[nCows+1][nCows+1];
        for(int[] row : matrix){
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < kRelations; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String relation = stringTokenizer.nextToken();
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            if ("S".equals(relation)) {
                matrix[a][b] = 0; //same
                matrix[b][a] = 0; //same
            } else {
                matrix[a][b] = 1; //diff
                matrix[b][a] = 1; //diff
            }
        }
        breedArray = new int[nCows + 1];
        int count = checkTheIndexCowMatching(1);
        System.out.println(count);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(count);
        printWriter.flush();
    }

    static int checkTheIndexCowMatching(int i) {
        int count = 0;
        boolean isConflicting = false;

        if (i > nCows) {
            return 1;
        }
        for (int j = 1; j <= 3; j++) {
            isConflicting = false;
            for (int k = 1; k < i; k++) {
                if ((matrix[k][i] == 0 && breedArray[k] != j) || matrix[k][i] == 1 && breedArray[k] == j) {
                    isConflicting = true;
                    break;
                }
            }
            if (!isConflicting) {
                breedArray[i] = j;
                count += checkTheIndexCowMatching(i + 1);
            }
        }
        return count;
    }

}

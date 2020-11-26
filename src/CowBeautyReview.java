import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class CowBeautyReview {
    static int nRows = 0;
    static int nCols = 0;
    static int[][] matrix;
    static int spotIndex = 11;

    static void getExtendedSpot(int i, int j) {
        if (i < 0 || j < 0 || i >= nRows || j >= nCols) {
            return;
        }
        if (matrix[i][j] == 1) {
            matrix[i][j] = spotIndex;
            getExtendedSpot(i + 1, j);
            getExtendedSpot(i, j + 1);
            getExtendedSpot(i - 1, j);
            getExtendedSpot(i, j - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "pageant";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        nRows = Integer.parseInt(stringTokenizer.nextToken());
        nCols = Integer.parseInt(stringTokenizer.nextToken());

        matrix = new int[nRows][nCols];
        for (int i = 0; i < nRows; i++) {
            String thisRow = bufferedReader.readLine();
            for (int j = 0; j < thisRow.length(); j++) {
                matrix[i][j] = 'X' == thisRow.charAt(j) ? 1 : 0;
            }
        }
        thisNext:
        for (int i = 0; i < nRows ; i++) {
            for (int j = 0; j < nCols; j++) {
                if( matrix[i][j] == 1){
                    getExtendedSpot(i, j);
                    break thisNext;
                }
            }
        }
        spotIndex = -11;
        nextNext:
        for (int i = 0; i < nRows ; i++) {
            for (int j = 0; j < nCols; j++) {
                if( matrix[i][j] == 1){
                    getExtendedSpot(i, j);
                    break nextNext;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                for (int k = 0; k < nRows; k++) {
                    for (int l = 0; l < nCols; l++) {
                        if (matrix[i][j] != matrix[k][l] && (matrix[i][j] + matrix[k][l]) == 0) {
                            minDistance = Math.min(minDistance, Math.abs(i - k) + Math.abs(j - l) -1 );
                        }
                    }
                }
            }
        }
        System.out.println(minDistance);

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(minDistance);
        printWriter.flush();
    }

}

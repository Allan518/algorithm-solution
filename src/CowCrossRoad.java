import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CowCrossRoad {
    static int cowCountOnOneSide;
    static int[] top;
    static int[] bottom;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cowCountOnOneSide = scanner.nextInt();

        top = new int[cowCountOnOneSide + 1];
        bottom = new int[cowCountOnOneSide + 1];
        matrix = new int[cowCountOnOneSide + 1][cowCountOnOneSide + 1];

        for (int i = 1; i <= cowCountOnOneSide; i++) {
            top[i] = scanner.nextInt();
        }

        for (int i = 1; i <= cowCountOnOneSide; i++) {
            bottom[i] = scanner.nextInt();
        }
        boolean firstFlag = true;

//        1        2        3        4        5        6
//        6        5        4        3        2        1
        for (int i = 1; i <= cowCountOnOneSide; i++) {
            firstFlag = true;
            for (int j = 1; j <= cowCountOnOneSide; j++) {
                int ans = 0;
                if (matrix[i - 1][j] > 0) {
                    ans = Math.max(ans, matrix[i - 1][j]);
                }
                if (matrix[i][j - 1] > 0) {
                    ans = Math.max(ans, matrix[i][j - 1]);
                }
                if (matrix[i - 1][j - 1] > 0 && isFriend(top[i], bottom[j])) {
                    ans = Math.max(ans, matrix[i - 1][j - 1] + 1);
                }
                if (firstFlag && ans == 0 && isFriend(top[i], bottom[j])) {
                    ans++;
                    firstFlag = false;
                }
                matrix[i][j] = ans;
            }
        }
        System.out.println(matrix[cowCountOnOneSide][cowCountOnOneSide]);
    }

    static boolean isFriend(int i, int j) {
        if (Math.abs(i - j) <= 4) {
            return true;
        } else return false;
    }
}

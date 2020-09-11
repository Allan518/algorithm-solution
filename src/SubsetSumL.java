import java.util.Scanner;

public class SubsetSumL {
    static int n;
    static int[] arr;
    static long[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int total = n * (n + 1) / 4;
        if ((n % 4) == 1 || (n % 4) == 2) {
            System.out.println(0);
        }
        int[][] matrix = new int[n + 1][total + 1];
        matrix[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= total; j++) {
                matrix[i][j] = matrix[i - 1][j];
                if (j >= i) {
                    matrix[i][j] = matrix[i][j] + matrix[i - 1][j - i];
                }
            }
        }

        System.out.println(matrix[n][total]);

    }
}

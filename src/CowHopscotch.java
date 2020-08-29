import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowHopscotch {  //Allan
    static int[][] grid;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int columns = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        grid = new int[rows][columns];
        dp = new long[rows][columns];
        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(rows - 1, columns - 1));
    }

    static long solve(int row, int column) {
        if (row == 0 && column != 0 || row != 0 && column == 0) {
            return 0;
        }
        if (row == 0 && column == 0) {
            return 1;
        }
        if (dp[row][column] == -1) {
            long ans = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (grid[i][j] != grid[row][column]) {
                        ans += solve(i, j);
                    }
                }
            }
            dp[row][column] = ans % 1000000007;
        }
        return dp[row][column] % 1000000007;
    }
}
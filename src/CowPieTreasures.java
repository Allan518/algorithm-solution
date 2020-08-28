import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowPieTreasures {
    static int[][] dp;
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int columns = Integer.parseInt(st.nextToken());
        grid = new int[rows][columns];
        dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(grid.length - 1, grid[0].length - 1));
    }

    static int solve(int row, int column) {
        if (column == 0) {
            if (row != 0) {
                return Integer.MIN_VALUE;
            }
            return grid[0][0];
        }
        if (dp[row][column] == -1) {
            int ans = Integer.MIN_VALUE;
            if (row + 1 < grid.length && column - 1 >= 0) {
                ans = Math.max(ans, solve(row + 1, column - 1));
            }
            if (column - 1 >= 0) {
                ans = Math.max(ans, solve(row, column - 1));
            }
            if (column - 1 >= 0 && row - 1 >= 0) {
                ans = Math.max(ans, solve(row - 1, column - 1));
            }
            ans += grid[row][column];
            dp[row][column] = ans;
        }
        return dp[row][column];
    }
}
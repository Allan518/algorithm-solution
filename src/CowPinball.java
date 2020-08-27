import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowPinball { //Allan
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                for (; j <= i; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
                if (j > n - 1) {
                    break;
                }
                grid[i][j] = -1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    break;
                }
                grid[i][j] += Math.max(grid[i + 1][j], grid[i + 1][j + 1]);
            }
        }
        System.out.println(grid[0][0]);
    }
}
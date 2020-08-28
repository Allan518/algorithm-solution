import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BullsAndCows {
    static int[] dp;
    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            dp[i] = -1;
        }
        System.out.println(solve(length));
    }
    static int solve(int length) {
        if (length <= 0) {
            return 1;
        }
        if (dp[length] == -1) {
            dp[length] = (solve(length - 1) + solve(length - k - 1)) % 5000011;
        }
        return dp[length];
    }
}
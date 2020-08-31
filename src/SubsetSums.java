import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubsetSums {
    static long[][] dp;
    static int[] arr;
    static int sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sum = (n * (n + 1)) / 2;
        dp = new long[n + 1][sum + 1];
        arr = new int[n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        System.out.println(solve(0, 0));
    }

    static long solve(int index, int currSum) {
        if (sum % 2 == 1) {
            return 0;
        }
        if (index == arr.length - 1) {
            if (currSum == sum / 2) {
                return 1;
            }
            return 0;
        }
        if (dp[index][currSum] == -1) {
            long ans = 0;
            ans += solve(index + 1, currSum);
            ans += solve(index + 1, currSum + arr[index + 1]);
            dp[index][currSum] = ans;
        }
        return dp[index][currSum];
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class MeetingTime {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("meeting.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("meeting.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] bessieGrid = new int[n][n];
        int[][] elsieGrid = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            bessieGrid[a][b] = Integer.parseInt(st.nextToken());
            elsieGrid[a][b] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp1 = new boolean[n][100 * n + 1];
        dp1[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dp1[i].length; j++) {
                if (!dp1[i][j]) {
                    continue;
                }
                for (int k = i + 1; k < n; k++) {
                    if (bessieGrid[i][k] > 0) {
                        dp1[k][j + bessieGrid[i][k]] = true;
                    }
                }
            }
        }
        boolean[][] dp2 = new boolean[n][100 * n + 1];
        dp2[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dp2[i].length; j++) {
                if (!dp2[i][j]) {
                    continue;
                }
                for (int k = i + 1; k < n; k++) {
                    if (elsieGrid[i][k] > 0) {
                        dp2[k][j + elsieGrid[i][k]] = true;
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < dp1[n-1].length; i++) {
            if (dp1[n - 1][i] && dp2[n - 1][i]) {
                answer = i;
                break;
            }
        }
        if (answer == Integer.MAX_VALUE) {
            pw.println("IMPOSSIBLE");
        } else {
            pw.println(answer);
        }
        pw.flush();
    }
}
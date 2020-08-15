import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ElectionTimeL {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int[][] votes = new int[N][3];


        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer((bufferedReader.readLine()));
            votes[i][0] = i + 1;
            votes[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            votes[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(votes, Comparator.comparingInt(arr -> arr[1]));
        int[][] votesAgain = new int[K][3];
        votesAgain = Arrays.copyOfRange(votes, N - K,  N);

        Arrays.sort(votesAgain, Comparator.comparingInt(arr -> arr[2]));
        System.out.println(votesAgain[K-1][0]);

    }
}

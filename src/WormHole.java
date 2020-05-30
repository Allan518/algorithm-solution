import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WormHole {
    static int MAX_N = 12;

    static int[] X = new int[MAX_N + 1];
    static int[] Y = new int[MAX_N + 1];
    static int N;
    static int[] partner = new int[MAX_N + 1];
    static int[] next_on_right = new int[MAX_N + 1];

    static boolean cycle_exists() {
        for (int start = 1; start <= N; start++) {
            // does there exist a cylce starting from start
            int pos = start;
            for (int count = 0; count < N; count++)
                pos = next_on_right[partner[pos]];
            if (pos != 0) return true;
        }
        return false;
    }

    // count all solutions
    static int solve() {
        // find first unpaired wormhole
        System.out.print("inside solve\t");
        int i, total = 0;
        for (i = 1; i <= N; i++) {
            System.out.print("i = " + i + "\t");
            if (partner[i] == 0) {
                break;
            }
        }

        // everyone paired?
        if (i > N) {
            if (cycle_exists()) {
                System.out.println("all paired! RETURN 1");
                return 1;
            } else {
                System.out.println("all paired! RETURN 0");
                return 0;
            }
        }

        // try pairing i with all possible other wormholes j
        for (int j = i + 1; j <= N; j++)
            if (partner[j] == 0) {
                // try pairing i & j, let recursion continue to
                // generate the rest of the solution
                partner[i] = j;
                partner[j] = i;
                System.out.print(i + " " + j + "\t");
                System.out.println(Arrays.toString(partner));
                total += solve();
                System.out.print("outside solve\t");
                System.out.print(i + " " + j + " set as 0");
                partner[i] = partner[j] = 0;
                System.out.println(Arrays.toString(partner));
            }
        System.out.println("return " + total + " " + Arrays.toString(partner));
        return total;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("wormhole.out"));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            X[i + 1] = Integer.parseInt(stringTokenizer.nextToken());
            Y[i + 1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 1; i <= N; i++) // set next_on_right[i]...
            for (int j = 1; j <= N; j++)
                if (X[j] > X[i] && Y[i] == Y[j]) // j right of i...
                    if (next_on_right[i] == 0 ||
                            X[j] - X[i] < X[next_on_right[i]] - X[i])
                        next_on_right[i] = j;

        int result = solve();
        printWriter.println(result);
        System.out.println(result);
        printWriter.flush();
    }
}

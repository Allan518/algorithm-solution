import java.io.*;
import java.util.StringTokenizer;

public class SwapitySwap {
    static int[] array;
    static int[][] matrix;
    static int A1, A2, B1, B2;

    public static void main(String[] args) throws Exception {
        int N, K;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("swap.in"));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i + 1;
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        A1 = Integer.parseInt(stringTokenizer.nextToken());
        A2 = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        B1 = Integer.parseInt(stringTokenizer.nextToken());
        B2 = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 1; i <= N; i++) {
            int t = 1;
            int cur = nextValue(i);
            while (cur != i) {
                t++;
                cur = nextValue(cur);
            }
            int k = K % t;
            for (int j = 0; j < k; j++) {
                cur = nextValue(cur);
            }
            array[cur - 1] = i;
        }


        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        for (int i = 0; i < N; i++) {
//            System.out.println(array[i]);
            printWriter.println(array[i]);
        }
        printWriter.flush();
    }

    static int nextValue(int x) {
        if (x >= A1 && x <= A2) {
            x = A1 + A2 - x;
        }
        if (x >= B1 && x <= B2) {
            x = B1 + B2 - x;
        }
        return x;
    }

}

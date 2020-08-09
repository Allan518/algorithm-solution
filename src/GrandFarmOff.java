import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class GrandFarmOff {//L?

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N, a, b, c, d, e, f, g, h, M;
        N = Integer.parseInt(stringTokenizer.nextToken());
        a = Integer.parseInt(stringTokenizer.nextToken());
        b = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());
        d = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());
        f = Integer.parseInt(stringTokenizer.nextToken());
        g = Integer.parseInt(stringTokenizer.nextToken());
        h = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        long[][] cowMatrix = new long[N * 3][2];
        for (int i = 0; i < 3 * N; i++) {
            cowMatrix[i][0] = (a * valueAfterMod(i, 5, d) + b * valueAfterMod(i, 2, d) + c) % d;
            cowMatrix[i][1] = (e * valueAfterMod(i, 5, h) + f * valueAfterMod(i, 2, d) + g) % h;
        }
        Arrays.sort(cowMatrix, Comparator.comparingLong(ar -> ar[1]));

        long result = 0;
        for( int i = 2*N ; i < 3*N; i++){
            result += cowMatrix[i][0];
        }
        System.out.println(result%M);

    }

    static long valueAfterMod(long cowIndex, long powerNumber, long modNumber) {
        long result = 1;
        for (int i = 0; i < powerNumber; i++) {
            result = (result * cowIndex) % modNumber;
        }
        return result;
    }


}

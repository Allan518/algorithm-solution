import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CowntactTracing {
    static int[][] matrix;
    static boolean[] cowStatusArray;
    static boolean[] cowPatientZeroFlag;
    static boolean[] shakingTimes;
    static int N, T;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("tracing.in"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("tracing.out"));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        T = Integer.parseInt(stringTokenizer.nextToken());

        String cowStatus = bufferedReader.readLine();
        cowStatusArray = new boolean[N];
        for (int i = 0; i < N; i++) {
            cowStatusArray[i] = Integer.parseInt(cowStatus.substring(i, i + 1)) == 1;
        }


        cowPatientZeroFlag = new boolean[N];
        shakingTimes = new boolean[T + 1];

        matrix = new int[T][3];

        for (int i = 0; i < T; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            matrix[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            matrix[i][1] = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            matrix[i][2] = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        }

        Arrays.sort(matrix, Comparator.comparingInt(arr -> arr[0]));

        int patientZeroCounter = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= T; j++) {
                if (isValidCase(i, j)) {
                    cowPatientZeroFlag[i] = true;
                    shakingTimes[j] = true;
                }
            }
        }
        int minK = N + 1;
        int maxK = 0;
        for (int i = 0; i < N; i++) {
            if (cowPatientZeroFlag[i]) {
                patientZeroCounter++;
            }
        }
        for (int i = 0; i <= T; i++) {
            if (shakingTimes[i]) {
                minK = Math.min(minK, i);
                maxK = Math.max(maxK, i);
            }
        }


        printWriter.println(patientZeroCounter + " " + minK + " " + (maxK == T  ? "Infinity" : maxK));
        printWriter.flush();
    }

    static boolean isValidCase(int cowPosition, int kTimes) {
        boolean[] cowInfections = new boolean[N];
        int[] cowPassingTimes = new int[N];
        cowInfections[cowPosition] = true;
        for (int i = 0; i < T; i++) {
            if (cowInfections[matrix[i][1]] && cowInfections[matrix[i][2]]) {
                cowPassingTimes[matrix[i][1]]++;
                cowPassingTimes[matrix[i][2]]++;
            } else if (cowInfections[matrix[i][1]]) {
                if (cowPassingTimes[matrix[i][1]] < kTimes ) {
                    cowInfections[matrix[i][2]] = true;
                    cowPassingTimes[matrix[i][1]]++;
                }
            } else if (cowInfections[matrix[i][2]]) {
                if (cowPassingTimes[matrix[i][2]] < kTimes ) {
                    cowInfections[matrix[i][1]] = true;
                    cowPassingTimes[matrix[i][2]]++;
                }
            }
        }
        boolean result = true;
        for (int i = 0; i < N; i++) {
            if (cowStatusArray[i] != cowInfections[i]) {
                return false;
            }
        }
        return result;
    }

}

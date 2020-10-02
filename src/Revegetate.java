import java.io.*;
import java.util.StringTokenizer;

public class Revegetate {
    static int[] A = new int[151];
    static int[] B = new int[151];
    static int[] G_pastureSeedType = new int[101];
    static int N_pasture;
    static int M_cows;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("revegetate.in"));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N_pasture = Integer.parseInt(stringTokenizer.nextToken());
        M_cows = Integer.parseInt(stringTokenizer.nextToken());
        int tmp = 0;
        for (int i = 0; i < M_cows; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            B[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (A[i] > B[i]) {
                tmp = A[i];
                A[i] = B[i];
                B[i] = tmp;
            }

        }
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        for (int i = 1; i <= N_pasture; i++) {
            int grassType;
            for (grassType = 1; grassType <= 4; grassType++) {
                boolean isOkay = true;
                for (int j = 0; j < M_cows; j++) {
                    if (B[j] == i && G_pastureSeedType[A[j]] == grassType) {
                        isOkay = false;
                    }
                }
                if (isOkay) {
                    break;
                }
            }
            G_pastureSeedType[i] = grassType;
            printWriter.print(grassType);
            System.out.print(grassType);
        }
        printWriter.println();
        printWriter.flush();
    }
}


import java.io.*;
import java.util.StringTokenizer;

public class GrazingPatterns {
    static int nBarrens = 0;
    static int[][] matrix = new int[5][5];
    static int totalStep;
    static int routeCounter;

    public static void main(String[] args) throws Exception {
        String fileName = "grazing";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));
        nBarrens = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer;
        for (int i = 0; i < nBarrens; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            matrix[a - 1][b - 1] = 1;
        }

        routeCounter = nextStep(0, 0);
        System.out.println(routeCounter);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(routeCounter);
        printWriter.flush();
    }

    static int nextStep(int i, int j) {
        int counter = 0;
        if (i < 0 || j < 0 || i > 4 || j > 4) {
            return 0;
        }
        if (matrix[i][j] == 1) {
            return 0;
        }

        matrix[i][j] = 1;
        totalStep++;
        if (i == 4 && j == 4 && totalStep == 25 - nBarrens ) {
            counter = 1;
        }else{
            counter = nextStep(i + 1, j) + nextStep(i, j + 1) + nextStep(i - 1, j) + nextStep(i, j-1);
        }
        totalStep--;
        matrix[i][j] = 0;
        return counter;
    }
}

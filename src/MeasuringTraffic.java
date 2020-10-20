import java.io.*;
import java.util.StringTokenizer;

//        4
//        on 1 1
//        none 10 14
//        none 11 15
//        off 2 3
//
public class MeasuringTraffic {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("traffic.in"));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] matrix = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            matrix[i][0] = convertRamp(4 - stringTokenizer.nextToken().length());
            matrix[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            matrix[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int xn = 0;
        int yn = 1000;
        int x = 0;
        int y = 1000;
        for (int i = 0; i < N; i++) {
            if (matrix[i][0] == 0) {
                x = Math.max(x, matrix[i][1]);
                y = Math.min(y, matrix[i][2]);

            } else if (matrix[i][0] == -1) {
                x = Math.max(0, x - matrix[i][2]);
                y = Math.min(1000, y - matrix[i][1]);

            } else {
                x = x + matrix[i][1];
                y = Math.min(1000, y + matrix[i][2]);
            }
        }
        xn = x;
        yn = y;
        int tmp = 0;
        x = 0;
        y = 1000;
        for (int i = N - 1; i >= 0; i--) {
            if (matrix[i][0] == 0) {
                x = Math.max(x, matrix[i][1]);
                y = Math.min(y, matrix[i][2]);

            } else if (matrix[i][0] == -1) {
                x = x + matrix[i][1];
                y = y + matrix[i][2];
            } else {
                x = x - matrix[i][2];
                y = y - matrix[i][1];
                x = Math.max(0, x);
            }
        }
        System.out.println(x + " " + y);
        System.out.println(xn + " " + yn);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
        printWriter.println(x + " " + y);
        printWriter.println(xn + " " + yn);
        printWriter.flush();
    }
    static int convertRamp(int i) {
        if (i == 2) return 1;
        else if (i == 1) return -1;
        else return i;
    }
}

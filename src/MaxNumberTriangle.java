import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaxNumberTriangle {
    static int[][] triangle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("numtri.out"));
        int size = Integer.parseInt(br.readLine());
        triangle = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int k = i + 1; k < size; k++) {
                triangle[i][k] = -1;
            }
        }
        for (int i = triangle.length - 2; i >= 0; i--) {
            column:
            for (int j = 0; j < triangle.length; j++) {
                if (triangle[i][j] == -1) {
                    break column;
                }
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        pw.println(triangle[0][0]);
        System.out.println(triangle[0][0]);
        pw.flush();
    }

}

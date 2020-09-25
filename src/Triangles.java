import java.io.*;
import java.awt.Point;
import java.util.StringTokenizer;

public class Triangles {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("triangles.in"));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(0, 0);
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            points[i].x = Integer.parseInt(stringTokenizer.nextToken());
            points[i].y = Integer.parseInt(stringTokenizer.nextToken());
        }

        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (points[i].y == points[j].y && j != i) {
                    for (int k = 0; k < N ; k++) {
                        if( points[i].x == points[k].x && k != i && k != j){
                            area = Math.max(area, Math.abs((points[i].x - points[j].x) * (points[i].y - points[k].y)));
                        }
                    }
                }
            }
        }

        PrintWriter printWriter  = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
//        System.out.println(area);
        printWriter.print(area);
        printWriter.flush();
    }
}

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class MooTube {  //bfs
    static int nVideos = 0;
    static int qQueries;

    public static void main(String[] args) throws Exception {
        String fileName = "mootube";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        nVideos = Integer.parseInt(stringTokenizer.nextToken());
        qQueries = Integer.parseInt(stringTokenizer.nextToken());

        LinkedList<Point>[] edges = new LinkedList[nVideos];
        for (int i = 0; i < nVideos; i++) {
            edges[i] = new LinkedList<Point>();
        }
        for (int i = 0; i < nVideos - 1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int w = Integer.parseInt(stringTokenizer.nextToken());
            edges[a].add(new Point(b, w));
            edges[b].add(new Point(a, w));
        }
        for (int i = 0; i < qQueries; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int threhold = Integer.parseInt(stringTokenizer.nextToken());
            int video = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            LinkedList<Integer> queue = new LinkedList();
            boolean[] visited = new boolean[nVideos];
            queue.add(video);
            int count = 0;
            while (!queue.isEmpty()) {
                int videoIndex = queue.removeFirst();
                if (visited[videoIndex]) {
                    continue;
                } else {
                    visited[videoIndex] = true;
                }

                for (Point thisEdge : edges[videoIndex]) {
                    if (thisEdge.y >= threhold) {
                        if (!visited[thisEdge.x]) {
                            queue.add(thisEdge.x);
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
            printWriter.println(count);
        }
        printWriter.flush();
    }
}

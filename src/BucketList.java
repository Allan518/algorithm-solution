import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BucketList {
    static int N = 0;

    public static void main(String[] args) throws Exception {
        String fileName = "blist";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));
        StringTokenizer stringTokenizer = null;
        N = Integer.parseInt(bufferedReader.readLine());

        int[][] matrix = new int[N][3];
        Map<Integer, Integer> cowBucketMap = new TreeMap<>();

        for (int i = 0; i < N ; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            matrix[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            matrix[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            matrix[i][2] = Integer.parseInt(stringTokenizer.nextToken());
            cowBucketMap.put(matrix[i][0], matrix[i][2]);
            cowBucketMap.put(matrix[i][1], -matrix[i][2]);
        }

        int maxBucket = 0;
        int currentBucket = 0;
        for (Integer cowTiming: cowBucketMap.keySet()
             ) {
            currentBucket += cowBucketMap.get(cowTiming);
            maxBucket = Math.max(maxBucket, currentBucket);
        }

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(maxBucket);
        printWriter.flush();
    }

}

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
//http://usaco.org/index.php?page=viewproblem2&cpid=832

public class MilkingOrder {  //todo
    static int N = 0;
    static int M = 0;
    static int K = 0;
    static int[] position;
    static int[] suborder;
    static int[][] fixedOrder;
    static HashMap<Integer, Integer> subMap;
    static HashMap<Integer, Integer> fullMap;

    public static void main(String[] args) throws Exception {
        String fileName = "milkorder";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        int onePos = -1;

        position = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        suborder = new int[M];
        subMap = new HashMap<>();
        for (int i = 0; i < M; i++) {
            suborder[i] = Integer.parseInt(stringTokenizer.nextToken());
            subMap.put(suborder[i], i);
        }
        fullMap = new HashMap<>();
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int cowID = Integer.parseInt(stringTokenizer.nextToken());
            int thisPosition = Integer.parseInt(stringTokenizer.nextToken());
            if( cowID == 1){
                onePos = thisPosition ;
            }
            position[thisPosition - 1] = cowID;
            fullMap.put(cowID, thisPosition);
        }
        if( onePos == -1  ) {
            for (int i = N - 1; i >= 0; i--) {
                for (int j = M - 1; j >= 0; j--) {
                    if (suborder[j] == position[i]) {
                        for (int k = j - 1; k >= 0; k--) {
                            for (int m = i--; m >= 0; m--) {
                                if (position[j] == 0) {
                                    position[j] = suborder[k];
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (position[i] == 0) {
                    onePos = i + 1;
                    break;
                }
            }
        }
        System.out.println(onePos);


        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(onePos);
        printWriter.flush();

    }

    static boolean isValid( int onePos){
        boolean result = false;
        if( position[onePos] == 0 ){
            position[onePos] = 1;
            for (int i = 0; i < M ; i++) {

            }

        }
        return result;
    }
}

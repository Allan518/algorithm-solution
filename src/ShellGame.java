import java.io.*;
import java.util.StringTokenizer;

public class ShellGame {
    static int[] A = new int[100];
    static int[] B = new int[100];
    static int[] guess = new int[100];
    static int N = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("shell.in"));
        N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            B[i] = Integer.parseInt(stringTokenizer.nextToken());
            guess[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxScore = 0;
        for( int i = 1; i <= 3; i++){
            maxScore = Math.max(maxScore, getScore(i));
        }
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        printWriter.print(maxScore);
        printWriter.flush();
        System.out.println(maxScore);
    }

    static int getScore(int pebbleLocation){
        int score = 0;
        for( int i = 0; i < N; i ++){
            if( A[i] == pebbleLocation ) {
                pebbleLocation = B[i];
            }
            else if( B[i] == pebbleLocation){
                pebbleLocation = A[i];
            }
            if( guess[i] == pebbleLocation){
                score++;
            }
        }
        return score;
    }
}

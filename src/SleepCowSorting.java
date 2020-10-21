import java.io.*;
import java.util.StringTokenizer;

public class SleepCowSorting {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sleepy.in"));

        int N = Integer.parseInt((bufferedReader).readLine());

        int[] cows =  new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for( int i = 0; i < N; i++){
            cows[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int orderedListFromEnd = 1;
        for( int i = N-1; i >= 1; i--){
            if( cows[i-1] < cows[i]){
                orderedListFromEnd++;
            }
            else{
                break;
            }
        }

        int timeToSort = N - orderedListFromEnd;
        System.out.println(timeToSort);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        printWriter.print(timeToSort);
        printWriter.flush();

    }

}

import java.io.*;
import java.util.StringTokenizer;

public class TamingTheHerd {
    static int N = 0;
    static int[] days;

    public static void main(String[] args) throws Exception {
        String fileName = "taming";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        N = Integer.parseInt(bufferedReader.readLine());
        days = new int[N];


        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        String outputStr = null;
        for (int i = 0; i < N; i++) {
            String s = tokenizer.nextToken();
            days[i] = Integer.parseInt(s);
            if (days[i] > 0) {
                if (days[i - days[i]] == -1) {
                    days[i - days[i]] = 0;
                } else if( days[i - days[i]] != 0 ){
                    outputStr = "-1";
                    break;
                }
                for (int j = 1; j <= days[i] - 1; j++) {
                    if( days[ i - j] == -1 ) {
                        days[ i - j] = -2;
                    }
                    else{
                        if( days[ i - j] !=  days[i] -j ){
                        //    outputStr = "-1";
                         //   break;
                        }
                    }
                }
                days[i] = -2;  //confirmed not breakout
            }
        }

        if (days[0] == -1) {
            days[0] = 0;
        }
        int min = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (days[i] >= 0) {
                min++;
                max++;
            }
            if( days[i] == -1 ){
                max++;
            }
        }
        if( outputStr == null){
            outputStr = min + " " + max;
        }
        System.out.println(outputStr);


        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(outputStr);
        printWriter.flush();
    }

}

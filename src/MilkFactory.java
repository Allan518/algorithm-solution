import java.io.*;
import java.util.StringTokenizer;

public class MilkFactory {
    static int N;
    static int[] in = new int[101];
    static int[] out = new int[101];

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("factory.in"));
        N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer ;
        for (int i = 0; i < N - 1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int outgoing = Integer.parseInt(stringTokenizer.nextToken());
            int inbound = Integer.parseInt(stringTokenizer.nextToken());
            out[outgoing]++;
            in[inbound]++;
        }

        int sinkNumber = 0;
        for (int i = 1; i <= N; i++) {
            int sink = 0;
            if (out[i] == 0) {
                if (sink == 0) {
                    sink = 1;
                    sinkNumber = i;
                } else {
                    sinkNumber = -1;
                    break;
                }
            }
        }

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        System.out.println(sinkNumber);
        printWriter.println(sinkNumber);
        printWriter.flush();
    }

}

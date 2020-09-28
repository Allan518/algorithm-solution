import java.io.*;
import java.util.StringTokenizer;


public class Race {

    static int K;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("race.in"));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        K = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        int[] speed = new int[N];

        for (int i = 0; i < N; i++) {
            speed[i] = Integer.parseInt(bufferedReader.readLine());
        }

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
        for (int i = 0; i < N; i++) {
            printWriter.println(solve(speed[i]));
            System.out.println(solve(speed[i]));
        }
        printWriter.flush();
    }

    static int solve(int lowSpeed) {
        int speed = 0;
        int ldistance = 0;
        int rdistance = 0;

        for (int timer = 0 ;;) {
            speed++;
            if( ldistance + rdistance >= K ){
                return timer;
            }
            else{
                timer++;
                ldistance += speed;
            }
            if( ldistance + rdistance >= K ) {
                return timer;
            }
            else{
                if (speed >= lowSpeed) {
                    timer++;
                    rdistance += speed;
                }
            }
        }
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class TelePort {

    static int N = 0;

    public static void main(String[] args) throws Exception {
        String fileName = "teleport";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int res1 = 0;
        int res2 = 0;
        if( a > b) {
            res1 = a;
            a = b;
            b = res1;
        }

        res1 = Math.min(Math.abs(a-x), Math.abs(b-x));
        res2 = Math.min(Math.abs(a-y), Math.abs(b-y));

        if( x > y ){
            res1 = Math.abs(b -x);
            res2 = Math.abs(y-a);
        }
        else{
            res1 = Math.abs(x -a);
            res2 = Math.abs(b -y);
        }


        int result = res1 + res2;
        result = Math.min(result, Math.abs(a-b));
        System.out.println(result);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(result);
        printWriter.flush();
    }

}

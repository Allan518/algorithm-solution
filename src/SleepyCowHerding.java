import java.io.*;
import java.util.StringTokenizer;

public class SleepyCowHerding {
    static int x, y, z;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("herding.in"));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        x = Integer.parseInt(stringTokenizer.nextToken());
        y = Integer.parseInt(stringTokenizer.nextToken());
        z = Integer.parseInt(stringTokenizer.nextToken());

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));

        printWriter.println(getMinTime(x,y,z));
        printWriter.println(getMaxTime(x,y,z));
        System.out.println(getMinTime(x,y,z));
        System.out.println(getMaxTime(x,y,z));
        printWriter.flush();
    }

    static int getMinTime( int x, int y , int z) {
        int time;
        int lgap = y - x;
        int rgap = z - y;
        int maxGap = Math.max(lgap, rgap);
        int minGap = Math.min(lgap, rgap);
        if (minGap == 1) {
                if( maxGap == 1) return 0;
                else return Math.min(2, maxGap - 1 );
        } else {
             return Math.min(Math.min(2, maxGap - 1 ), minGap -1);
        }
    }

    static int getMaxTime(int x, int y, int z){
        int time;
        int lgap = y - x;
        int rgap = z - y;
        int maxGap = Math.max(lgap, rgap) ;
        if( maxGap == 1 ){
            time = 0;
        }
        else{
            time = maxGap -1;
        }
        return time;
    }
}

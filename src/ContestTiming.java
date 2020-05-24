import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ContestTiming {
    static int getMinutesBetween(int[] start, int[] end){
        int minutes = 0;
        minutes += ( end[0]- start[0] )*1440;
        minutes += ( end[1] - start[1]) * 60;
        minutes +=  end[2]- start[2];
        return minutes;

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("ctiming.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] end = new int[3];
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());
        end[2] = Integer.parseInt(st.nextToken());

        int[] start = new int[3];
        start[0] = 11;
        start[1] = 11;
        start[2] = 11;
        PrintWriter pw = new PrintWriter(new FileWriter("ctiming.out"));
        pw.println( getMinutesBetween(start, end));
        pw.flush();
        System.out.println(getMinutesBetween(end, start));
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class SilverMooBuzz {
    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int inputSequence = Integer.parseInt(stringTokenizer.nextToken());
        int[] mapArray = {1, 2, 4, 7, 8, 11, 13, 14 };
        int index, multiple ;
        if( inputSequence % 8 == 0 ){
            if( inputSequence > 8 ) {
                multiple = inputSequence/8 - 1;
            }
            else{
                multiple = 0;
            }
            index = 7;
        }
        else{
            multiple = inputSequence/8;
            index = inputSequence % 8 -1 ;
        }

        long number = (long) multiple * 15 + mapArray[ index ];

        pw.println(number);
        pw.flush();
    }
}

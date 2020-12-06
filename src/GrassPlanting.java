import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
public class GrassPlanting {
    static int nFields = 0;

    public static void main(String[] args) throws Exception {
        String fileName = "planting";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        nFields = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;

        int[] fieldDegree = new int[nFields];
        for (int i = 0; i < nFields -1 ; i++) {
            stringTokenizer = new StringTokenizer((bufferedReader.readLine()));
            fieldDegree[Integer.parseInt(stringTokenizer.nextToken())-1]++;
            fieldDegree[Integer.parseInt(stringTokenizer.nextToken())-1]++;
        }

        int maxDegree = 0;
        for (int i = 0; i < nFields ; i++) {
            if( fieldDegree[i] > maxDegree){
                maxDegree = fieldDegree[i];
            }
        }

        System.out.println(maxDegree+1);

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(maxDegree+1);
        printWriter.flush();
    }

}

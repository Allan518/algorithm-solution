import java.io.*;
import java.util.StringTokenizer;

public class Proximity {
    public static void main(String[] args) throws Exception {
        long x = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("proximity.in"));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int numberOfCows = Integer.parseInt(stringTokenizer.nextToken());
        int proximity = Integer.parseInt(stringTokenizer.nextToken());
        int[] cowIDs = new int[numberOfCows];
        int maxCowID = -1;
        for(int i = 0; i < numberOfCows; i++) cowIDs[i] = Integer.parseInt(br.readLine());
        for(int i = 0; i < numberOfCows; i++){
            if(cowIDs[i] > maxCowID){
                for(int j = 1; j <= proximity; j++){
                    if(i + j < numberOfCows && cowIDs[i] == cowIDs[i + j]){
                        maxCowID = cowIDs[i];
                    }
                }
            }
        }
        System.out.println(maxCowID);
        PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("proximity.out")));
        pr.println(maxCowID);
        pr.flush();
        long y = System.currentTimeMillis();
        System.out.println("time spent =" + (y - x));
    }
}

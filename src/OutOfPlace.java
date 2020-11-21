import java.io.*;
import java.util.*;
public class OutOfPlace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        int[] sorted = new int[n];
        for(int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sorted[i] = height[i];
        }
        Arrays.sort(sorted);
        int swaps = -1;
        for(int a = 0; a < n; a++) {
            if(sorted[a] != height[a]) {
                swaps++;
            }
        }
        swaps = Math.max(0, swaps);
        pw.println(swaps);
        pw.close();
    }

}
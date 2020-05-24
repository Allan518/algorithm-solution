import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SilverCereal {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("cereal.out"));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int numOfCows = Integer.parseInt(stringTokenizer.nextToken());
        int numOfCereal = Integer.parseInt(stringTokenizer.nextToken());
        int[][] cerealFavorites = new int[numOfCows][2];
        for (int i = 0; i < numOfCows; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            cerealFavorites[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            cerealFavorites[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] howManyCows = new int[numOfCows];
        int cows = 0;
        int[] occ = new int[numOfCows + 1];
        for (int i = numOfCows - 1; i >= 0; i--) {
            int j = i;
            int pos = cerealFavorites[i][0];
            while (true) {
                if (occ[pos] == 0) {
                    occ[pos] = j;
                    cows++;
                    break;
                } else if (occ[pos] < j)
                    break;
                else {
                    int k = occ[pos];
                    occ[pos] = j;
                    if (pos == cerealFavorites[k][1])
                        break;
                    j = k;
                    pos = cerealFavorites[k][1];
                }
            }
            howManyCows[i] = cows;
        }
        for (int i = 0; i < numOfCows; i++) {
            System.out.println(howManyCows[i]);
            printWriter.println(howManyCows[i]);
        }
        printWriter.flush();
    }
}

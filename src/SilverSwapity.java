import java.io.*;
import java.util.*;

public class SilverSwapity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCows = Integer.parseInt(st.nextToken());
        int totalPairsForReversal = Integer.parseInt(st.nextToken());
        int repeatTimes = Integer.parseInt(st.nextToken());
        int[] currentRowArrays = new int[totalCows];
        int[] beginningCowsArray = new int[totalCows];
        for (int i = 0; i < totalCows; i++) beginningCowsArray[i] = i;
        while (totalPairsForReversal-- > 0) {
            st = new StringTokenizer(br.readLine());
            int LowerEndOfPairsForReversal = Integer.parseInt(st.nextToken()) - 1;
            int HigherEndOfPairsForReversal = Integer.parseInt(st.nextToken()) - 1;
            while (LowerEndOfPairsForReversal < HigherEndOfPairsForReversal) {
                int t = beginningCowsArray[LowerEndOfPairsForReversal];
                beginningCowsArray[LowerEndOfPairsForReversal] = beginningCowsArray[HigherEndOfPairsForReversal];
                beginningCowsArray[HigherEndOfPairsForReversal] = t;
                LowerEndOfPairsForReversal++;
                HigherEndOfPairsForReversal--;
            }
        }
        for (int i = 0; i < totalCows; i++) currentRowArrays[i] = beginningCowsArray[i];

        int[] returnArray = new int[totalCows];
        for (int i = 0; i < totalCows; i++) returnArray[i] = i + 1;
        while (repeatTimes > 0) {
            if (repeatTimes % 2 == 1) {
                returnArray = applyOneRoundPosition(returnArray, currentRowArrays);
            }
            repeatTimes /= 2;
            if (repeatTimes > 0) currentRowArrays = applyOneRoundPosition(currentRowArrays, currentRowArrays);
        }
        for (int val : returnArray) pw.println(val);
        pw.close();
    }

    public static int[] applyOneRoundPosition(int[] l, int[] op) {
        int[] ret = new int[l.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = l[op[i]];
        }
        return ret;
    }
}
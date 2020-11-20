import java.io.*;
import java.util.StringTokenizer;
//http://usaco.org/index.php?page=viewproblem2&cpid=832

public class MilkingOrder {  //todo
    static boolean[] usedCow = new boolean[100];
    static boolean[] usedPos = new boolean[100];
    static int[] pos = new int[100];

    static int nCows, M, nFixed;

    static int[] ord = new int[100];

    static int[] cFixed = new int[101];
    static int[] pFixed = new int[101];

    public static void main(String[] args) throws Exception {
        String fileName = "milkorder";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        nCows = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        nFixed = Integer.parseInt(stringTokenizer.nextToken());

        int onePos = -1;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            ord[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < nFixed; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            cFixed[i] = Integer.parseInt(stringTokenizer.nextToken());
            pFixed[i] = Integer.parseInt(stringTokenizer.nextToken());
            cFixed[i]--;
            pFixed[i]--;
        }
        nFixed++;
        for (int i = 0; i < nCows; i++) {
            cFixed[nFixed - 1] = 0;
            pFixed[nFixed - 1] = i;
            if (isValid()) {
                onePos = i + 1;
                break;
            }
        }
        System.out.println(onePos);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(onePos);
        printWriter.flush();
    }

    static boolean isValid() {
        for (int i = 0; i < nCows; i++) {
            usedCow[i] = false;
            usedPos[i] = false;
        }
        for (int i = 0; i < nFixed; i++) {
            if (usedCow[cFixed[i]] && pos[cFixed[i]] == pFixed[i]) {
                continue;
            }
            if (usedCow[cFixed[i]]  ) {
                return false;
            }
            if (usedPos[pFixed[i]]) {
                return false;
            }
            usedCow[cFixed[i]] = true;
            usedPos[pFixed[i]] = true;
            pos[cFixed[i]] = pFixed[i];
        }
        int j = 0;
        for (int i = 0; i < M; i++) {
            int cow = ord[i];
            if (usedCow[cow]) {
                if (j > pos[cow]) {
                    return false;
                }
                j = pos[cow];
                continue;
            }
            while (usedPos[j]) {
                j++;
                if (j == nCows) {
                    return false;
                }
            }
            usedPos[j] = true;
            pos[cow] = j;
        }
        return true;
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class LiveStockLineUp {

    static boolean passRules(int number, HashSet[] thisSet) {
        long a3 = System.currentTimeMillis();
        boolean result = true;
        String numberStr = String.valueOf(number);
        for (int i = 0; i < thisSet.length; i++) {
            Iterator<String> iterator = thisSet[i].iterator();
            int matchTimes = 0;
            while (iterator.hasNext()) {
                if (numberStr.contains(iterator.next())) {
                    matchTimes++;
                    break;
                }
            }
            if (matchTimes == 0) {
                long a5 = System.currentTimeMillis();
                System.out.println("passRules fast: " + ( a5 - a3));
                return false;
            }
        }
        long a4 = System.currentTimeMillis();
        System.out.println("passRules " + ( a4 - a3));
        return result;
    }

    static boolean isDinstinct(int i, int j, int k, int l, int m, int n, int p, int q) {
        /*
        if ( i != j && i !=k && i !=l && i != m && i!= n && i!=p && i!=q ){
            if ( j !=k && j !=l && j != m && j!= n && j!=p && j!=q ){
                if (  k !=l && k != m && k!= n && k!=p && k!=q ){
                    if ( l != m && l!= n && l!=p && l!=q ){
                        if ( m!= n && m!=p && m!=q ){
                            if (  n!=p && n!=q ){
                                if (  p!=q ){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        */
        long a3 = System.currentTimeMillis();
        boolean result = false;
        HashSet hashSet = new HashSet();
        hashSet.add(i);
        hashSet.add(j);
        hashSet.add(k);
        hashSet.add(l);
        hashSet.add(m);
        hashSet.add(n);
        hashSet.add(p);
        hashSet.add(q);
        if (hashSet.size() == 8) result = true;
        else result = false;
        long a4 = System.currentTimeMillis();
        System.out.println("isDistinct " + ( a4 - a3));
        return result;
    }

    public static void main(String[] args) throws Exception {
        long x = System.currentTimeMillis();
        BufferedReader bf = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lineup.out"));

        int totalRules = Integer.parseInt(bf.readLine());
        System.out.println("totalRules = " + totalRules);


        String[] cows = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
        HashMap<String, Integer> cowHash = new HashMap<>();
        for (int i = 0; i < cows.length; i++) {
            cowHash.put(cows[i], i);
        }
        //Buttercup must be milked beside Bella
        //Blue must be milked beside Bella

        int[][] pairs = new int[totalRules][2];
        String thisRule = "";
        for (int i = 0; i < totalRules; i++) {
            thisRule = bf.readLine();
            pairs[i][0] = cowHash.get(thisRule.substring(0, thisRule.indexOf(" ")));
            pairs[i][1] = cowHash.get(thisRule.substring(thisRule.lastIndexOf(" ") + 1));
        }
        HashSet[] thisSet = new HashSet[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            thisSet[i] = new HashSet();
            thisSet[i].add(String.valueOf(pairs[i][0] + 1) + String.valueOf(pairs[i][1] + 1));
            thisSet[i].add(String.valueOf(pairs[i][1] + 1) + String.valueOf(pairs[i][0] + 1));
        }

        //Sue must be milked beside Beatrice
        //int[][] pairs = {{1, 5}, {6, 5}, {7, 3}};
        int total = 8;
        int minimum = Integer.MAX_VALUE;
        int number = 0;
        long a1, a2, a3 =0, a4=0;
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                for (int k = 0; k < total; k++) {
                    for (int l = 0; l < total; l++) {
                        for (int m = 0; m < total; m++) {
                            for (int n = 0; n < total; n++) {
                                for (int p = 0; p < total; p++) {
                                    for (int q = 0; q < total; q++) {
                                        a1 = System.currentTimeMillis();
                                        number = (i + 1) * 10000000
                                                + (j + 1) * 1000000
                                                + (k + 1) * 100000
                                                + (l + 1) * 10000
                                                + (m + 1) * 1000
                                                + (n + 1) * 100
                                                + (p + 1) * 10
                                                + (q + 1);
                                        a2 = System.currentTimeMillis();
                                        System.out.println( " agri" + (a2- a1));
                                        if (number < minimum) {
                                            if (isDinstinct(i, j, k, l, m, n, p, q)) {
                                                if (passRules(number, thisSet)) {
                                                    a4 = System.currentTimeMillis();
                                                    minimum = number;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(minimum);
        String output = String.valueOf(minimum);
        for (int i = 0; i < output.length(); i++) {
            pw.println(cows[Integer.parseInt(Character.toString(output.charAt(i))) - 1]);
        }
        pw.flush();
        long y = System.currentTimeMillis();
        System.out.println("ms = " + (y - x));
    }
}

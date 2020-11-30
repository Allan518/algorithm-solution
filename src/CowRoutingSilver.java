import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class CowRoutingSilver {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("cowroute.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowroute.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;
        int n = Integer.parseInt(st.nextToken());
        long[][] costs = new long[1000][1000];
        int[][] flights = new int[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                costs[i][j] = Long.MAX_VALUE / 3;
                flights[i][j] = Integer.MAX_VALUE / 3;
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cities = Integer.parseInt(st.nextToken());
            int[] arr = new int[cities];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cities; j++) {
                arr[j] = Integer.parseInt(st.nextToken()) - 1;
            }
            for (int j = 0; j < cities; j++) {
                for (int k = j; k < cities; k++) {
                    if (j != k) {
                        if (cost < costs[arr[j]][arr[k]]) {
                            costs[arr[j]][arr[k]] = cost;
                            flights[arr[j]][arr[k]] = k - j;
                            continue;
                        }
                        if (cost == costs[arr[j]][arr[k]]) {
                            flights[arr[j]][arr[k]] = Math.min(flights[arr[j]][arr[k]], k - j);
                        }
                    }
                }
            }
        }
        long[] minCost = new long[1000];
        for (int i = 0; i < 1000; i++) {
            minCost[i] = Long.MAX_VALUE / 3;
        }
        int[] minFlights = new int[1000];
        for (int i = 0; i < 1000; i++) {
            minFlights[i] = Integer.MAX_VALUE / 3;
        }
        class node {
            int plane;
            int num;
            long cost;

            public node(int plane, int num, long cost) {
                this.num = num;
                this.cost = cost;
                this.plane = plane;
            }
        }
        ArrayDeque<node> q = new ArrayDeque<node>();
        minCost[start] = 0;
        minFlights[start] = 0;
        q.add(new node(start, 0, 0));
        while (!q.isEmpty()) {
            node curr = q.remove();
            int plane = curr.plane;
            long cost = curr.cost;
            int num = curr.num;
            for (int i = 0; i < 1000; i++) {
                long nextCost = cost + costs[plane][i];
                int nextNum = num + flights[plane][i];
                if (nextCost < minCost[i]) {
                    minCost[i] = nextCost;
                    minFlights[i] = nextNum;
                    q.add(new node(i, nextNum, nextCost));
                }
                if (nextCost == minCost[i]) {
                    if (nextNum < minFlights[i]) {
                        minFlights[i] = nextNum;
                        q.add(new node(i, nextNum, nextCost));
                    }
                }
            }
        }
        if (minCost[end] == Long.MAX_VALUE / 3) {
            pw.println((-1) + " " + (-1));
        } else {
            pw.println(minCost[end] + " " + minFlights[end]);
        }
        pw.flush();
    }
}
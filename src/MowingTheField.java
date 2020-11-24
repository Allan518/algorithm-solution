import java.io.*;
import java.util.*;
public class MowingTheField {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        // todo
        BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));

        /*
         * Create a two-dimensional array where lastTime[i][j] stores the last time
         * that Farmer John visited point (i, j). If Farmer John has never visited that
         * point, then lastTime[i][j] == -1.
         */
        int[][] lastTime = new int[2001][2001];
        for(int i = 0; i < lastTime.length; i++) {
            for(int j = 0; j < lastTime[i].length; j++) {
                lastTime[i][j] = -1;
            }
        }

        // (currX, currY) is the point that Farmer John is currently at.
        int currX = 1000;
        int currY = 1000;
        lastTime[currX][currY] = 0;
        int currentTime = 0;

        // the longest period of time cannot exceed 1000, so if it is still 1001, he never visits the same square twice.
        int answer = 100 * 10 + 1;

        // read in N
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // read in the direction that Farmer John goes in
            String direction = st.nextToken();
            int dirX = 0;
            int dirY = 0;
            if(direction.equals("N")) {
                dirX = -1;
            }
            else if(direction.equals("S")) {
                dirX = 1;
            }
            else if(direction.equals("W")) {
                dirY = -1;
            }
            else {
                dirY = 1;
            }
            // read in the number of steps he travels
            int numSteps = Integer.parseInt(st.nextToken());
            // travel that many steps
            for(int j = 1; j <= numSteps; j++) {
                currX += dirX;
                currY += dirY;
                currentTime++;
                // check if Farmer John has visited that square before, and the amount of time that has elapsed since then if valid
                if(lastTime[currX][currY] >= 0 && currentTime - lastTime[currX][currY] < answer) {
                    answer = currentTime - lastTime[currX][currY];
                }
                lastTime[currX][currY] = currentTime;
            }
        }
        // check if he has never visited the same square twice
        if(answer == 1001) {
            answer = -1;
        }
        // print the answer
        pw.println(answer);
        // close file I/O
        pw.close();
    }
}
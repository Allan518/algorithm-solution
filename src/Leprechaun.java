import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Leprechaun { //allan
    static int[][] arr;
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dimension = Integer.parseInt(br.readLine());
        arr = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < dimension; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int row = 0; row < dimension; row++) {
            for (int column = 0; column < dimension; column++) {
                getSum(row, column);
            }
        }
        System.out.println(maxSum);
    }

    static void getSum(int row, int column) {
        HashSet<Point> alreadyVisited = new HashSet<Point>();
        int currSum = 0;
        for (int currRow = row; ; currRow++) {
            if (alreadyVisited.contains(new Point(currRow % arr.length, column))) {
                break;
            }
            currSum += arr[currRow % arr.length][column % arr.length];
            maxSum = Math.max(maxSum, currSum);
            alreadyVisited.add(new Point(currRow % arr.length, column));
        }
        currSum = 0;
        alreadyVisited.clear();
        for (int currColumn = column; ; currColumn++) {
            if (alreadyVisited.contains(new Point(row, currColumn % arr.length))) {
                break;
            }
            currSum += arr[row % arr.length][currColumn % arr.length];
            maxSum = Math.max(maxSum, currSum);
            alreadyVisited.add(new Point(row, currColumn % arr.length));
        }
        currSum = 0;
        alreadyVisited.clear();
        loop:
        for (int n = 0; ; n++) {
            if (alreadyVisited.contains(new Point(((row - n) + arr.length) % arr.length, ((column - n) + arr.length) % arr.length))) {
                break loop;
            }
            currSum += arr[((row - n) + arr.length) % arr.length][((column - n) + arr.length) % arr.length];
            maxSum = Math.max(maxSum, currSum);
            alreadyVisited.add(new Point(((row - n) + arr.length) % arr.length, ((column - n) + arr.length) % arr.length));
        }
        currSum = 0;
        alreadyVisited.clear();
        loop:
        for (int n = 0; ; n++) {
            if (alreadyVisited.contains(new Point(((row - n) + arr.length) % arr.length, (column + n) % arr.length))) {
                break loop;
            }
            currSum += arr[((row - n) + arr.length) % arr.length][(column + n) % arr.length];
            maxSum = Math.max(maxSum, currSum);
            alreadyVisited.add(new Point(((row - n) + arr.length) % arr.length, (column + n) % arr.length));
        }
    }
}

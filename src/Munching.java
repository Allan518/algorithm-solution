import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Munching {
    static int shortestRoute = 10000;
    static String[] pasture;
    static HashMap<Point, Integer> visitCount = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int columns = Integer.parseInt(st.nextToken());
        int bessieRow = 0;
        int bessieColumn = 0;
        pasture = new String[rows];
        for (int i = 0; i < rows; i++) {
            pasture[i] = br.readLine();
            for (int j = 0; j < columns; j++) {
                if (pasture[i].charAt(j) == 'C') {
                    bessieRow = i;
                    bessieColumn = j;
                }
            }
        }
        findRoute(bessieRow, bessieColumn, 1);
        System.out.println(shortestRoute);
    }

    static void findRoute(int row, int column, int count) {
        if (visitCount.containsKey(new Point(row, column))) {
            if (count < visitCount.get(new Point(row, column))) {
                visitCount.put(new Point(row, column), count);
            } else {
                return;
            }
        } else {
            visitCount.put(new Point(row, column), count);
        }
        if (count - 1 > shortestRoute) {
            return;
        }
        if (row == 0 && column == 0) {
            shortestRoute = Math.min(shortestRoute, count - 1);
            return;
        }
        if (column < pasture[0].length() - 1 && pasture[row].charAt(column + 1) != '*') {
            findRoute(row, column + 1, count + 1);
        }
        if (row < pasture.length - 1 && pasture[row + 1].charAt(column) != '*') {
            findRoute(row + 1, column, count + 1);
        }
        if (column > 0 && pasture[row].charAt(column - 1) != '*') {
            findRoute(row, column - 1, count + 1);
        }
        if (row > 0 && pasture[row - 1].charAt(column) != '*') {
            findRoute(row - 1, column, count + 1);
        }
    }
}
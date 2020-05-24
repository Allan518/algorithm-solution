import java.io.*;

public class Perimeter {
    static final int MAX_N = 100;
    static int[][] already_visited = new int[MAX_N+2][MAX_N+2];
    static int[][] occupied = new int[MAX_N+2][MAX_N+2];
    static int perimeter;

    static boolean valid(int x, int y) {
        return x >= 0 && x <= (MAX_N + 1) && y >= 0 && y <= MAX_N + 1;
    }

    static void visit(int x, int y) {
        if (occupied[x][y] == 1) {
            perimeter++;
            return;
        }
        if (already_visited[x][y] == 1) return;
        already_visited[x][y] = 1;
        if (valid(x - 1, y)) visit(x - 1, y);
        if (valid(x + 1, y)) visit(x + 1, y);
        if (valid(x, y - 1)) visit(x, y - 1);
        if (valid(x, y + 1)) visit(x, y + 1);
    }

    public static void main(String[] args) throws Exception{
        int N, i, x, y;
        BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));

        N = Integer.parseInt(br.readLine());
        for (i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            occupied[Integer.parseInt(row[0])][Integer.parseInt(row[1])] = 1;
        }

        visit(0, 0);
        System.out.println(perimeter);
        pw.println(perimeter);
        pw.flush();
    }
}
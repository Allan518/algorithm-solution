import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CowEscapeRecursive {
    static int n;
    static int[] w = new int[20];
    static int best = 0;

    /* Can x and y be added with no carries? */
    static boolean check(int x, int y) {
        for (; x > 0 && y > 0; x /= 10, y /= 10)
            if (x % 10 + y % 10 >= 10) return false;
        return true;
    }

    /*
       x = index into w array we're currently considering (i.e., we have already
       added a subset of w[1...x-1] and are considering whether to add w[x]).
       sum = cumulative sum of subset added so far.
       count = number of elements in subset added so far.
    */
    static void rec(int x, int sum, int count) {
        if (count > best) {
            best = count;
        }
        if (x >= n || count + n - x <= best) {
            return;
        }
        if (check(sum, w[x])) {
            rec(x + 1, sum + w[x], count + 1);
        }
        rec(x + 1, sum, count);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new FileReader("escape.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("escape.out"));

        n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(bf.readLine());
        }

        rec(0, 0, 0);

        System.out.println(best);
        pw.println(best);
        pw.flush();
    }
}

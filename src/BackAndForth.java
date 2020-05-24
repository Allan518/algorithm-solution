import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BackAndForth {
    static HashSet<Integer> possibilities = new HashSet<>();

    static void friday(int b1Milk, int theBucket, ArrayList clonedFirst, ArrayList clonedSecond) {
        possibilities.add(b1Milk + theBucket);
        System.out.println(possibilities);
    }

    static void thursday(int b1Milk, int theBucket, ArrayList clonedFirst, ArrayList clonedSecond) {
        clonedSecond.add(theBucket);
        for (int i = 0; i < clonedFirst.size(); i++) {
            if ((int) clonedFirst.get(i) == theBucket) {
                clonedFirst.remove(i);
                break;
            }
        }
        b1Milk -= theBucket;
        for (int i = 0; i < clonedSecond.size(); i++) {
            friday(b1Milk, (int) clonedSecond.get(i), clonedFirst, clonedSecond);
        }
    }


    static void wednesday(int b1Milk, int theBucket, ArrayList clonedFirst, ArrayList clonedSecond) {
        clonedFirst.add(theBucket);
        for (int i = 0; i < clonedSecond.size(); i++) {
            if ((int) clonedSecond.get(i) == theBucket) {
                clonedSecond.remove(i);
                break;
            }
        }
        b1Milk += theBucket;
        for (int i = 0; i < clonedFirst.size(); i++) {
            thursday(b1Milk, (int)clonedFirst.get(i), clonedFirst, clonedSecond);
        }
    }


    static void tuesday(int b1Milk, int theBucket, ArrayList clonedFirst, ArrayList clonedSecond) {
        clonedSecond.add(theBucket);
        for (int i = 0; i < clonedFirst.size(); i++) {
            if ((int) clonedFirst.get(i) == theBucket) {
                clonedFirst.remove(i);
                break;
            }
        }
        b1Milk -= theBucket;
        for (int i = 0; i < clonedSecond.size(); i++) {
            wednesday(b1Milk, (int)clonedSecond.get(i), clonedFirst, clonedSecond);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("backforth.out"));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        ArrayList<Integer> firstBuckets = new ArrayList<>();
        ArrayList<Integer> secondBuckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            firstBuckets.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            secondBuckets.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> clonedFirst = new ArrayList<>();
            clonedFirst.addAll(firstBuckets);
            ArrayList<Integer> clonedSecond = new ArrayList<>();
            clonedSecond.addAll(secondBuckets);
            tuesday(1000, (int)firstBuckets.get(i), clonedFirst, clonedSecond);
        }
        System.out.println(possibilities.size());
        printWriter.println(possibilities.size());
        printWriter.flush();
    }
}

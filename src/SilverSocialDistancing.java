import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SilverSocialDistancing {
    static int lowest;
    static int highest;
    static int smallestDistance = 1;
    static int highestDistance;

    static int binary(boolean isGreater, int mid) {
        if (isGreater) {
            smallestDistance = mid;
            mid = (smallestDistance + highestDistance) / 2;
        }
        if (!isGreater) {
            highestDistance = mid;
            mid = (smallestDistance + highestDistance) / 2;
        }
        return mid;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("socdist.out"));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int numOfCows = Integer.parseInt(stringTokenizer.nextToken());
        int numOfIntervals = Integer.parseInt(stringTokenizer.nextToken());
        int[][] theIntervals = new int[numOfIntervals][2];
        highest = 0;
        lowest = Integer.MAX_VALUE;
        for (int i = 0; i < numOfIntervals; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            theIntervals[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            theIntervals[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            highest = Math.max(highest, theIntervals[i][1]);
            lowest = Math.min(lowest, theIntervals[i][0]);
        }
        highestDistance = highest - lowest;
        Arrays.sort(theIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return Integer.compare(ints[0], t1[0]);
            }
        });
        int maxDistance = 0;
        int i = (highestDistance) / 2;
        int previous;
        while (true) {
            boolean isGreater;
            int count = 0;
            int num = 0;
            for (int j = 0; j < numOfIntervals; j++) {
                if (num > theIntervals[j][1]) {
                    continue;
                }
                if (num < theIntervals[j][0]) {
                    num = theIntervals[j][0];
                }
                count++;
                while (true) {
                    if(num + i > theIntervals[j][1]){
                        break;
                    }
                    num += i;
                    count++;
                }
                num += i;
            }
            if (count < numOfCows) {
                isGreater = false;
            } else {
                isGreater = true;
                maxDistance = Math.max(maxDistance, i);
            }
            previous = i;
            i = binary(isGreater, i);
            if (i == previous) {
                break;
            }
        }
        System.out.println(maxDistance);
        printWriter.println(maxDistance);
        printWriter.flush();

    }
}

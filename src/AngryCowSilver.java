import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AngryCowSilver {  //allan
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfBales = Integer.parseInt(st.nextToken());
        int availableCows = Integer.parseInt(st.nextToken());
        int[] baleLocations = new int[numOfBales];
        for (int i = 0; i < numOfBales; i++) {
            baleLocations[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(baleLocations);
        int min = 0;
        int max = 500000000;
        while (min != max) {
            int mid = (min + max) / 2;
            int usedCows = 0;
            int index = 0;
            while (index < numOfBales) {
                usedCows++;
                int curr = index + 1;
                while (curr < numOfBales && baleLocations[curr] - baleLocations[index] <= 2 * mid) {
                    curr++;
                }
                index = curr;
            }
            if (usedCows <= availableCows) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }
}
/*
    Angry Cows
==========

        Bessie the cow has designed what she thinks will be the next big hit
        video game: "Angry Cows". The premise, which she believes is
        completely original, is that the player shoots cows with a slingshot
        into a one-dimensional scene consisting of a set of hay bales located
        at various points on a number line. Each cow lands with sufficient
        force to detonate the hay bales in close proximity to her landing
        site. The goal is to use a set of cows to detonate all the hay bales.

        There are N hay bales located at distinct integer positions
        x1,x2,...,xN on the number line. If a cow is launched with power R
        landing at position x, this will causes a blast of "radius R",
        destroying all hay bales within the range x-R...x+R.

        A total of K cows are available to shoot, each with the same power R.
        Please determine the minimum integer value of R such that it is
        possible to use the K cows to detonate every single hay bale in the
        scene.

        PROBLEM NAME: angry

        INPUT FORMAT:

        The first line of input contains N (1 <= N <= 50,000) and K (1 <= K
        <= 10). The remaining N lines all contain integers x1...xN (each in
        the range 0...1,000,000,000).

        OUTPUT FORMAT:

        Please output the minimum power R with which each cow must be
        launched in order to detonate all the hay bales.

        SAMPLE INPUT:

        7 2
        20
        25
        18
        8
        10
        3
        1

        SAMPLE OUTPUT:

        5

        Problem credits: Brian Dean
*/
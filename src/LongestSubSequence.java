import java.util.Scanner;

public class LongestSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int num = sc.nextInt();
        int[] count = new int[num];
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        count[0] = 1;
        for (int i = 1; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    count[i] = Math.max(count[i], count[j]);
                }
            }
            count[i]++;
            answer = Math.max(answer, count[i]);
        }
        System.out.println(answer);
    }
}
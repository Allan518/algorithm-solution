import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubArray {
    public static List<Integer> getShortestSubsequence(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;

        int[] prefixSum = new int[arr.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = prefixSum[j + 1] - prefixSum[i];
                if (sum % k == 0 && (j - i + 1) < minLength) {
                    minLength = j - i + 1;
                    result.clear();
                    for (int x = i; x <= j; x++) {
                        result.add(arr[x]);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            return new ArrayList<>();
        }
        return result;
    }

    public static int[] getShortestSubsequenceL(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[0];
        int prefixMod = 0;

        ArrayList<Integer>[] modGroups = new ArrayList[k];
        for (int i = 0; i < k ; i++) {
            modGroups[i] = new ArrayList<Integer>();
        }

        int minLength = Integer.MAX_VALUE;
        int index = 0;
        for (int num: nums) {
            // Take modulo twice to avoid negative remainders.
            int currentMod = ( num % k + k) % k;
            if ( currentMod == 0 ){
                result = new int[]{num};
                break;
            }
            prefixMod = (prefixMod + num % k + k) % k;
            // Add the count of subarrays that have the same remainder as the current
            // one to cancel out the remainders.
            modGroups[prefixMod].add(index++);
            if (modGroups[prefixMod].size() > 1){
                int leftIndex = modGroups[prefixMod].get(modGroups[prefixMod].size() - 2) ;
                int rightIndex =  modGroups[prefixMod].get(modGroups[prefixMod].size() - 1);
                int currentLength = leftIndex - leftIndex + 1;
                if (currentLength < minLength) {
                    result = new int[currentLength];
                    for( int i = leftIndex; i < rightIndex; i ++){
                        result[ i - leftIndex] = nums[i];
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {14, 5, 7, -2, 5, 1};
        int k = 19;
        System.out.println(Arrays.toString(getShortestSubsequenceL(arr, k)));
    }
}
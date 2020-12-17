import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class RentalService {

    static int nCows = 0;
    static int mStores = 0;
    static int rRentals = 0;
    static int[] cowArray;
    static int[][] storeMatrix;
    static int[][] storeMatrixOriginal;
    static int[] rentalArray;

    public static void main(String[] args) throws Exception {
        String fileName = "rental";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long totalIncome = 0;

        nCows = Integer.parseInt(stringTokenizer.nextToken());
        mStores = Integer.parseInt(stringTokenizer.nextToken());
        rRentals = Integer.parseInt(stringTokenizer.nextToken());

        cowArray = new int[nCows];
        for (int i = 0; i < nCows; i++) {
            cowArray[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(cowArray);
        int[] cowArrayOriginal =  cowArray.clone();


        storeMatrix = new int[mStores][3];
        for (int i = 0; i < mStores; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            storeMatrix[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            storeMatrix[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(storeMatrix, Comparator.comparingInt(arr -> -1 * arr[1]));
        storeMatrixOriginal = new int[mStores][3];
        for (int i = 0; i < mStores; i++) {
            storeMatrixOriginal[i][0] = storeMatrix[i][0];
            storeMatrixOriginal[i][1] = storeMatrix[i][1];
        }

        rentalArray = new int[rRentals];
        for (int i = 0; i < rRentals; i++) {
            rentalArray[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int[] rentalArrayOriginal = Arrays.stream(rentalArray)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        rentalArray = Arrays.copyOf(rentalArrayOriginal, rRentals);
        int rentalQuantity = Math.min(nCows, rRentals);
        for (int i = rentalQuantity; i >= 0; i--) {
            cowArray = cowArrayOriginal.clone();
            storeMatrix = new int[mStores][3];
            for (int j = 0; j < mStores; j++) {
                storeMatrix[j][0] = storeMatrixOriginal[j][0];
                storeMatrix[j][1] = storeMatrixOriginal[j][1];
            }

            long thisIncome = calculateTotalIncome(i, storeMatrix);
            totalIncome = Math.max(totalIncome, thisIncome);
        }
        System.out.println(totalIncome);

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(totalIncome);
        printWriter.flush();
    }

    static long calculateTotalIncome(int rentalQuantity, int[][] storeMatrixOriginal) {
        int[][] localStoreMatrix = storeMatrixOriginal;
        long rentalIncome = 0;
        long storeIncome = 0;
        long localTotalIncome = 0;
        for (int i = 0; i < rentalQuantity; i++) {
            rentalIncome += rentalArray[i];
        }

        int cows4Store = Math.max(nCows - rentalQuantity, 0);
        int storesFilled = 0;
        for (int i = 0; i < cows4Store; ) {
            if (nCows - storesFilled - i -1 < 0) {
                break;
            }
            if (cowArray[nCows - storesFilled - i - 1] >= localStoreMatrix[storesFilled][0]) {
                storeIncome += localStoreMatrix[storesFilled][0] * localStoreMatrix[storesFilled][1];
                cowArray[nCows - storesFilled - i - 1] -= localStoreMatrix[storesFilled][0];
                storesFilled++;
                if (storesFilled >= mStores) {
                    break;
                }
            } else {
                storeIncome += cowArray[nCows - storesFilled - 1] * localStoreMatrix[storesFilled][1];
                localStoreMatrix[storesFilled][0] -= cowArray[nCows - storesFilled - 1];
                i++;
            }
        }
        localTotalIncome = rentalIncome + storeIncome;
        return localTotalIncome;
    }
}

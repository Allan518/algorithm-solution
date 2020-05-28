import java.io.*;
import java.util.*;

public class SilverBerryPicker {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("berries.in"));
        PrintWriter bufferedWriter = new PrintWriter(new BufferedWriter( new FileWriter("berries.out")));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int totalTreeN = Integer.parseInt(stringTokenizer.nextToken());
        int totalBasketK = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] berryNumberAtTree = new int[totalTreeN];
        int j = 0;
        int maxBerriesAtTree = 0;
        for( int tmp : berryNumberAtTree){
            berryNumberAtTree[j] = Integer.parseInt(stringTokenizer.nextToken());
            maxBerriesAtTree = Math.max( maxBerriesAtTree, berryNumberAtTree[j]);
            j++;
        }
        System.out.println(maxBerriesAtTree);
        System.out.println(Arrays.toString(berryNumberAtTree));

        int largestNumberOfBerryObtainedByBessie = 0;
        int[] remainingberryNumberAtTree = new int[totalTreeN];
        for( int berryNumberAtSmallestBasket = 1;  berryNumberAtSmallestBasket<= maxBerriesAtTree; berryNumberAtSmallestBasket++ ){
            int basketFilled = 0;
            for( int i = 0; i < totalTreeN; i++){
                basketFilled += berryNumberAtTree[i]/berryNumberAtSmallestBasket;
            }
            if( basketFilled < totalBasketK / 2 ){
                break;
            }
            if( basketFilled >= totalBasketK ){
                largestNumberOfBerryObtainedByBessie = Math.max( largestNumberOfBerryObtainedByBessie, berryNumberAtSmallestBasket* ( totalBasketK/2));
                continue;
            }
            for( int i = 0 ; i < totalTreeN; i++){
                remainingberryNumberAtTree[i]  = berryNumberAtTree[i] % berryNumberAtSmallestBasket;
            }
            Arrays.sort(remainingberryNumberAtTree);
            int berriesForBessie = berryNumberAtSmallestBasket*(basketFilled - totalBasketK/2);
            for( int i = totalTreeN -1; i >= 0 && (totalTreeN -i ) <= totalBasketK - basketFilled ; i--  ){
                    berriesForBessie += remainingberryNumberAtTree[i];
            }
            largestNumberOfBerryObtainedByBessie = Math.max(largestNumberOfBerryObtainedByBessie, berriesForBessie);
        }
        System.out.println(largestNumberOfBerryObtainedByBessie);
        bufferedWriter.println(largestNumberOfBerryObtainedByBessie);
        bufferedWriter.flush();
    }
}




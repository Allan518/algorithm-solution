import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BullsAndCowsL {
    static int totalCattle ;
    static int gap;
    static int[] resultArray;

    public static void main(String[] args) throws  Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        totalCattle = Integer.parseInt(stringTokenizer.nextToken());
        gap = Integer.parseInt(stringTokenizer.nextToken());
        resultArray = new int[totalCattle];

        System.out.println(getCombination(totalCattle -1 )%5000011);
    }


    static int getCombination(int pos){
        int result = 0;
        if(resultArray[pos] != 0 ){
            return resultArray[pos];
        }
        if( pos == 0 ){
            result = 2;
        }
        else if (pos <= gap){
            result = getCombination(pos -1 ) + 1;
        }
        else{
            result = (getCombination(pos -1 ) + getCombination(pos - gap -1 ))%5000011;
        }
        resultArray[pos] = result;
        return result;
    }
}

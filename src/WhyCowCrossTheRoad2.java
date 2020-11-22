import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class WhyCowCrossTheRoad2 {
    public static void main(String[] args) throws Exception {
        String fileName = "circlecross";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));
        String inputString = bufferedReader.readLine();
        int[][] matrix = new int[inputString.length()/2][2];
        for (int i = 0; i < matrix.length ; i++) {
            matrix[i][0] = -1;
        }
        for (int i = 0; i < inputString.length(); i++) {
            int charIndex = inputString.charAt(i) - 'A';
            if(matrix[charIndex][0] == -1 ) {
                matrix[charIndex][0] = i;
            }else{
                matrix[charIndex][1] = i;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        int totalCrossing = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set inSet = new HashSet<>();
            for (int j = matrix[i][0] +1 ; j < matrix[i][1]; j++) {
                int thisCharInt = inputString.charAt(j) - 'A';
                if( inSet.contains(thisCharInt) ){
                    inSet.remove(thisCharInt);
                }
                else{
                    inSet.add(thisCharInt);
                }
            }
            totalCrossing += inSet.size();
        }
        totalCrossing /= 2;
        System.out.println(totalCrossing);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(totalCrossing);
        printWriter.flush();
    }

}


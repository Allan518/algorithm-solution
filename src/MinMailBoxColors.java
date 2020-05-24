import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class MinMailBoxColors {
    public static int getMinMailBoxes(String boxArray) {
        int result = 1;
        Set hashSet = new HashSet();
        boolean foundIt = false;
        do {
            hashSet.clear();
            foundIt = false;
            for (int j = 0; j < boxArray.length() - result + 1; j++) {
                String movingScope = boxArray.substring(j, j + result);
                if (hashSet.contains(movingScope)) {
                    result++;
                    break;
                } else {
                    hashSet.add(movingScope);
                }
                if (j == boxArray.length() - result ) {
                    foundIt = true;
                }
            }
        } while ( ! foundIt || result == boxArray.length());
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader   = new BufferedReader(new FileReader("whereami.in"));
        int totalHome = Integer.parseInt(bufferedReader.readLine());
        String mailBoxColorList = bufferedReader.readLine();
        PrintWriter printWriter = new PrintWriter(new FileWriter("whereami.out"));
        printWriter.print(MinMailBoxColors.getMinMailBoxes(mailBoxColorList));
        printWriter.flush();
        System.out.println(MinMailBoxColors.getMinMailBoxes(mailBoxColorList));
    }
}

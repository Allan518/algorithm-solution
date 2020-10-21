import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

//          4
//        bird 2 flies eatsworms
//        cow 4 eatsgrass isawesome makesmilk goesmoo
//        sheep 1 eatsgrass
//        goat 2 makesmilk eatsgrass
public class GuessTheAnimal {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("guess.in"));

        int N = Integer.parseInt(bufferedReader.readLine());
        String[][] animalList = new String[N][];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            stringTokenizer.nextToken();
            int size = Integer.parseInt(stringTokenizer.nextToken());
            animalList[i] = new String[size];
            for (int j = 0; j < size; j++) {
                animalList[i][j] = stringTokenizer.nextToken();
            }
        }

        int commons = 0;
        for (int i = 0; i < N; i++) {
            for( int j = 1; j < N && j!= i; j++){
                commons = Math.max(commons, getCommons(animalList[i], animalList[j]));
            }
        }
        System.out.println(commons + 1 );
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
        printWriter.println( commons + 1);
        printWriter.flush();
    }

    static int getCommons(String[] a, String[] b){
        int result = 0;
        HashSet<String> thisSet = new HashSet<>();
          for( String x: a){
              thisSet.add(x);
          }
          for(String x: b){
              thisSet.add(x);
          }
        result = a.length + b.length - thisSet.size();
        return result;
    }
}

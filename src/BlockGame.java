import java.io.*;
import java.util.StringTokenizer;

public class BlockGame {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader("blocks.in"));
        int total = Integer.parseInt(bf.readLine());
        String[][] words = new String[total][2];
        int[] result = new int[26];

        for( int i = 0 ; i< total ; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
            words[i][0] = stringTokenizer.nextToken();
            words[i][1] = stringTokenizer.nextToken();
            int[] frontFrequency = getFrequency(words[i][0]);
            int[] backFrequency =  getFrequency(words[i][1]);
            for ( int j = 0; j < result.length ; j++){
                result[j] += Math.max(frontFrequency[j] , backFrequency[j]);
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        for( int i : result) {
            pw.println(i);
        }
        pw.flush();
    }

    static int[] getFrequency( String word ){
        char[] chars = word.toCharArray();
        int[] result = new int[26];
        for( char c: chars){
            result[c - 'a']++;
        }
        return result;
    }
}


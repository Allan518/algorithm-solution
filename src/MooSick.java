import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MooSick {
    static boolean isMatching(int[] source, int[] target){
        boolean result = false;
        Arrays.sort(source);
        Arrays.sort(target);
        for( int i = source.length - 1 ; i >= 0 ; i --) {
            source[i] = source[i] - source[0];
            target[i] = target[i] - target[0];
        }
        result = Arrays.equals(source, target);
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("moosick.in"));
        int totalLength = Integer.parseInt(br.readLine());
        int[] intArrys = new int[totalLength];
        for( int i = 0 ; i < totalLength; i++){
            intArrys[i] = Integer.parseInt(br.readLine());
        }


        int chordLength = Integer.parseInt( br.readLine());
        int[] chordArray = new int[chordLength];
        for( int i = 0 ; i < chordLength ; i++){
            chordArray[i] = Integer.parseInt( br.readLine());
        }

        PrintWriter pw = new PrintWriter ( new FileWriter("moosick.out"));

        Queue<Integer> queue = new LinkedList<>();

        for( int i = 0 ; i <= totalLength - chordLength ; i++ ){
            int[] movingSource = new int[chordLength];
            for( int j = 0 ; j < chordLength; j++ ) {
                movingSource[j] = intArrys[i + j];
            }
            if( isMatching(movingSource, chordArray)) {
                queue.add(i + 1);
            }
        }
        pw.println(queue.size());

        while( queue.peek() != null ) {
            pw.println(queue.poll());
        }

        pw.flush();
    }
}

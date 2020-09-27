import java.io.*;
import java.util.StringTokenizer;

public class PhotoShoot {

    public static void main(String[] args) throws Exception {
        int N = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("photo.in"));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        int[] bArray = new int[N - 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for( int i = 0;  i < N -1 ; i++){
            bArray[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));

        for( int i = 1; i <= N; i++){
            int[] aArray = new int[N];
            boolean[] used = new boolean[2*N + 1];
            boolean isBad = false;
            aArray[0] = i;
            used[i] = true;
            for( int j = 1; j < N; j ++){
                aArray[j] = bArray[j-1] - aArray[j -1];
                if( aArray[j] <= 0  || used[aArray[j]] ){
                    isBad = true;
                    break;
                }
                else{
                    used[aArray[j]] = true;
                }
            }
            if( !isBad ){
                for( int k = 0; k < N ; k++){
                    if( k == N -1 ) {
                        printWriter.println(aArray[k]);
//                        System.out.println(aArray[k]);
                    }
                    else{
                        printWriter.print(aArray[k] + " ");
//                        System.out.print(aArray[k] + " ");
                    }
                }
                break;
            }
        }
        printWriter.flush();
    }
}

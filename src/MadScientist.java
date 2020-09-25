import java.io.*;

public class MadScientist {
    public static void main(String[] args) throws  Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("breedflip.in"));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        String aString = bufferedReader.readLine();
        String bString = bufferedReader.readLine();

        boolean previousEqual = true;
        int counter = 0;
        for( int i = 0; i < N; i++){
            if( aString.charAt(i) == bString.charAt(i)){
                previousEqual = true;
            }
            else{
                if( previousEqual ){
                    counter++;
                    previousEqual = false;
                }
            }
        }

        PrintWriter printWriter = new PrintWriter( new BufferedWriter( new FileWriter("breedflip.out")));
        printWriter.print(counter);
        printWriter.flush();

    }

}

import java.io.*;

public class Censoring {
    public static void main(String[] args) throws Exception {
        long x = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("censor.in"));
        //StringBuilder magazine = new StringBuilder( br.readLine());
        String magazine =  br.readLine();
        String censorWord = br.readLine();
        int censorWordLength = censorWord.length();
        StringBuilder censoredWord = new StringBuilder();
        for (int i = 0; i < magazine.length(); i++) {
            censoredWord.append(magazine.charAt(i));
            if (censoredWord.length() >= censorWordLength &&
                    censoredWord.substring(censoredWord.length() - censorWordLength).equals(censorWord)) {
                censoredWord = new StringBuilder(censoredWord.substring(0, censoredWord.length() - censorWordLength));
            }
        }
//        PrintWriter printWriter = new PrintWriter(new FileWriter("censor.out"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
        printWriter.println(censoredWord);
        printWriter.flush();
        long y = System.currentTimeMillis();
       System.out.println("time spent = " + (y - x));
//        System.out.println(censoredWord);
    }
}

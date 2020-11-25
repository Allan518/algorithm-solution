import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class BessieGetEven {
    static int N = 0;
    static int matrix[][];
    static HashMap<String, int[]> rawMap;

    public static void main(String[] args) throws Exception {
        String fileName = "geteven";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));
        N = Integer.parseInt(bufferedReader.readLine());
        matrix = new int[N][2];
//      B,E,S,I,G,O,M
//      (B+E+S+S+I+E)(G+O+E+S)(M+O+O)

        StringTokenizer stringTokenizer;
        rawMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String character = stringTokenizer.nextToken();
            int[] evenOddArray = rawMap.get(character);
            if (evenOddArray == null) {
                evenOddArray = new int[2];
            }
            evenOddArray[Math.abs((Integer.parseInt(stringTokenizer.nextToken()))) % 2]++;
            rawMap.put(character, evenOddArray);
        }
        int B = 0;
        int E = 0;
        int S = 0;
        int I = 0;
        int G = 0;
        int O = 0;
        int M = 0;
        int counter = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int m = 0; m < 2; m++) {
                        for (int l = 0; l < 2; l++) {
                            for (int n = 0; n < 2; n++) {
                                for (int o = 0; o < 2; o++) {
                                    B = i;
                                    E = j;
                                    S = k;
                                    I = m;
                                    G = l;
                                    O = n;
                                    M = o;
                                    if (M % 2 == 0 || (B + I) % 2 == 0 || (G + O + E + S) % 2 == 0) {
                                        counter += rawMap.get("B")[i] * rawMap.get("E")[j] * rawMap.get("S")[k] *
                                                rawMap.get("I")[m] * rawMap.get("G")[l] * rawMap.get("O")[n] * rawMap.get("M")[o];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(counter);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        printWriter.println(counter);
        printWriter.flush();
    }

}

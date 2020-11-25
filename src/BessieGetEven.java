import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class BessieGetEven {
    static int N = 0;
    static int matrix[][];
    static HashMap<String, ArrayList<Integer>> rawMap;

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
            ArrayList<Integer> arrayList = rawMap.get(character);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(Integer.parseInt(stringTokenizer.nextToken()));
            rawMap.put(character, arrayList);
        }
        int B = 0;
        int E = 0;
        int S = 0;
        int I = 0;
        int G = 0;
        int O = 0;
        int M = 0;
        int counter = 0;
        for (int i = 0; i < rawMap.get("B").size(); i++) {
            for (int j = 0; j < rawMap.get("E").size(); j++) {
                for (int k = 0; k < rawMap.get("S").size(); k++) {
                    for (int m = 0; m < rawMap.get("I").size(); m++) {
                        for (int l = 0; l < rawMap.get("G").size(); l++) {
                            for (int n = 0; n < rawMap.get("O").size(); n++) {
                                for (int o = 0; o < rawMap.get("M").size(); o++) {
                                    B = rawMap.get("B").get(i);
                                    E = rawMap.get("E").get(j);
                                    S = rawMap.get("S").get(k);
                                    I = rawMap.get("I").get(m);
                                    G = rawMap.get("G").get(l);
                                    O = rawMap.get("O").get(n);
                                    M = rawMap.get("M").get(o);
                                    if( (B +I) % 2 == 0 || (G + O + E + S ) %2 == 0 || M %2 == 0){
                                        counter++;
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

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class TheGreatVevegetation {
    static int nPastures = 0;
    static int mCows = 0;
    static int[][] matrix;
    static ArrayList<Edge>[] adj;
    static int counter = 0;
    static int[] grassGroup;
    static boolean wrongCombination;

    public static void main(String[] args) throws Exception {
        String fileName = "revegetate";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".in"));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        nPastures = Integer.parseInt(stringTokenizer.nextToken());
        mCows = Integer.parseInt(stringTokenizer.nextToken());

        matrix = new int[mCows][3];

        for (int i = 0; i < mCows; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            matrix[i][0] = "S".equals(stringTokenizer.nextToken()) ? 0:1;  // S-> 0; D -> 1
            matrix[i][1] = Integer.parseInt(stringTokenizer.nextToken()) -1 ;
            matrix[i][2] = Integer.parseInt(stringTokenizer.nextToken()) -1 ;
        }

        adj = new ArrayList[nPastures];
        for (int i = 0; i < nPastures; i++) {
            adj[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < mCows; i++) {
            if( matrix[i][0] == 0 ){ //smae pasture
                adj[matrix[i][1]].add(new Edge(matrix[i][2], true));
                adj[matrix[i][2]].add(new Edge(matrix[i][1], true));
            }else{ //different pasture
                adj[matrix[i][1]].add(new Edge(matrix[i][2], false));
                adj[matrix[i][2]].add(new Edge(matrix[i][1], false));
            }
        }

        grassGroup = new int[nPastures];
        for (int i = 0; i < nPastures; i++) {
            if( wrongCombination){
                break;
            }
            if( grassGroup[i] == 0 ) {
                grassGroup[i] = 2*counter + 1;
                floodFill(i);
                counter++;
            }
        }
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        if(! wrongCombination){
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            for (int i = 0; i < counter; i++) {
                sb.append(0);
            }
            String result = sb.toString();
            System.out.println(result);
            printWriter.println(result);

        }
        else{
            printWriter.println("0");
        }
        printWriter.flush();
    }

    static void floodFill(int index){
        for(Edge e: adj[index]) {
            int v = e.pairNode;
            if (grassGroup[index] % 2 == 1) {
                if (e.sameTypeOfGrass) {
                    if( grassGroup[v] == 0){
                        grassGroup[v] = grassGroup[index];
                        floodFill(v);
                    } else if( grassGroup[v] != grassGroup[index]){
                        wrongCombination = true;
                        break;
                    }
                } else {
                    if(grassGroup[v] == 0 ){
                        grassGroup[v] = grassGroup[index] +1;
                        floodFill(v);
                    }else if ( grassGroup[v] == grassGroup[index]){
                        wrongCombination = true;
                        break;
                    }
                }
            } else {
                if (e.sameTypeOfGrass){
                    if(grassGroup[v] == 0 ) {
                        grassGroup[v] = grassGroup[index];
                        floodFill(v);
                    }else if(grassGroup[v] != grassGroup[index]){
                        wrongCombination = true;
                        break;
                    }
                }else{
                    if(grassGroup[v] == 0 ) {
                        grassGroup[v] = grassGroup[index] - 1;
                        floodFill(v);
                    }else if( grassGroup[v] == grassGroup[index]){
                        wrongCombination = true;
                        break;
                    }
                }
            }
        }
    }

    static class Edge{
        int pairNode;
        boolean sameTypeOfGrass;

        Edge(int pairNode_, boolean sameTypeOfGrass_){
            pairNode = pairNode_;
            sameTypeOfGrass = sameTypeOfGrass_;
        }
    }

}

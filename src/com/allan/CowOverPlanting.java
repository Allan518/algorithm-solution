package com.allan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.StringTokenizer;
class grid{
    int x;
    int y;

}

public class CowOverPlanting {

    static HashSet<String> totalGrids = new HashSet<>();

    static void processBox(int x1, int y1, int x2, int y2){
        for( int i = x1; i < x2; i++ ){
            for( int j = y1; j > y2; j--) {
                totalGrids.add( "" + i + "," + j);
            }
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("planting.in"));
        int totalBoxes = Integer.parseInt(br.readLine());
        int[][] boxRawData = new int[totalBoxes][4];

        StringTokenizer stringTokenizer = null;
        for( int i = 0; i < totalBoxes; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            boxRawData[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            boxRawData[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            boxRawData[i][2] = Integer.parseInt(stringTokenizer.nextToken());
            boxRawData[i][3] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int totalAreas;
        for( int i = 0; i < totalBoxes; i++ ){
            System.out.println("processing box " + i);
            processBox(boxRawData[i][0], boxRawData[i][1], boxRawData[i][2], boxRawData[i][3]);
            System.out.println(("finished box " + i + " ; size is " + totalGrids.size()));
        }
        System.out.println(totalGrids.size());

    }
}

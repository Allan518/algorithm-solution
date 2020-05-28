import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SilverSocialDistancing2 {
    static int highestGrassPosition;
    static int lowestGrassPosition;
    static boolean cowsPlacedTooClose;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("socdist.out"));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int totalNumberOfCows = Integer.parseInt(stringTokenizer.nextToken());
        int numberOfGrassSegments = Integer.parseInt(stringTokenizer.nextToken());
        int[][] grassSegmentsArray = new int[numberOfGrassSegments][2];
        for (int i = 0; i < numberOfGrassSegments; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            grassSegmentsArray[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            grassSegmentsArray[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            highestGrassPosition = Math.max(highestGrassPosition, grassSegmentsArray[i][1]);
            lowestGrassPosition = Math.min(lowestGrassPosition, grassSegmentsArray[i][0]);
        }
        int distanceBetweenTwoEndsOfGrassLine = highestGrassPosition - lowestGrassPosition;
        Arrays.sort(grassSegmentsArray, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                    }
                }
        );
        int cowPosition = lowestGrassPosition ;
        int cowPlaced = 0;
        int currentGapSearchLowEnd = lowestGrassPosition;
        int currentGapSearchHighEnd = highestGrassPosition;;
        int gapBetweenCows = (currentGapSearchHighEnd + currentGapSearchLowEnd )/2 ;

        int currentLargeGap = 0;
        int previousGap = 0;
        while( true ){
            for( int i = 0; i < numberOfGrassSegments; i++){
                if( cowPosition > grassSegmentsArray[i][1] ){
                    continue;
                }
                if( cowPosition <= grassSegmentsArray[i][0]){
                    cowPosition = grassSegmentsArray[i][0];
                }
                cowPlaced++;
                cowPosition += gapBetweenCows;
                while( cowPosition <= grassSegmentsArray[i][1]){
                    cowPlaced++;
                    cowPosition +=gapBetweenCows;
                }
            }

            if(cowPlaced >= totalNumberOfCows){
                cowsPlacedTooClose = true;
                currentLargeGap = Math.max(gapBetweenCows, currentLargeGap);
                if( previousGap == currentLargeGap) break;
            }
            else if( cowPlaced < totalNumberOfCows){
                cowsPlacedTooClose = false;
            }
            previousGap = gapBetweenCows;
            if( cowsPlacedTooClose ){
                currentGapSearchLowEnd = gapBetweenCows;
                gapBetweenCows = (currentGapSearchHighEnd + currentGapSearchLowEnd) / 2;
            } else{
                currentGapSearchHighEnd = gapBetweenCows;
                gapBetweenCows = (currentGapSearchLowEnd + currentGapSearchHighEnd) / 2;
            }
            cowPosition = lowestGrassPosition ;
            cowPlaced = 0;
        }
        System.out.println(currentLargeGap);
        printWriter.println(currentLargeGap);
        printWriter.flush();
    }
}

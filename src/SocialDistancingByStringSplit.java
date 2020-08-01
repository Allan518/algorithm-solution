import java.io.*;
import java.util.Arrays;
public class SocialDistancingByStringSplit {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("socdist1.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
        int stallCount = Integer.parseInt(bufferedReader.readLine());
        String stallString = bufferedReader.readLine();

        int[] maxGaps = new int[2];
        int minGap = stallCount;

        String[] distArray = stallString.split("1", -1);

        for( int i = 0; i < distArray.length; i++){
            System.out.println(distArray[i].length() + "\t" + (distArray[i].length() + 1 )/3 + "\t" + (distArray[i].length() + 1 )/2  + "\t" + distArray[i]);
        }
        System.out.println("end");
        if( distArray.length == 1){
            minGap = stallCount -1;
        }else if( distArray.length == 2){
            if( distArray[0].length() == 0 || distArray[1].length() == 0 ) {
                minGap = Math.max(distArray[0].length() / 2, distArray[1].length() / 2);
            }
            else{
                for( int i = 0; i < distArray.length ; i++){
                    if( distArray[i].length() > maxGaps[1]){
                        maxGaps[0] = maxGaps[1];
                        maxGaps[1] = distArray[i].length();
                    }
                    else if( distArray[i].length() > maxGaps[0]){
                        maxGaps[0] = distArray[i].length();
                    }
                }
                if ((maxGaps[1]  + 1 )/ 2 > (maxGaps[0] ) ){
                    minGap = Math.min(minGap, ( maxGaps[1] + 1) / 2);
                } else {
                    minGap = Math.min(minGap, maxGaps[0]);
                }
            }
        }else {
            for( int i = 1; i < distArray.length - 1; i++){
                minGap = Math.min(minGap, distArray[i].length() + 1); //
                if( distArray[i].length() > maxGaps[1]){
                    maxGaps[0] = maxGaps[1];
                    maxGaps[1] = distArray[i].length();
                }
                else if( distArray[i].length() > maxGaps[0]){
                    maxGaps[0] = distArray[i].length();
                }
            }
            int[] boundaryArray = new int[2];
            boundaryArray[1] =  Math.max(distArray[0].length(), distArray[distArray.length - 1].length());
            boundaryArray[0] =  Math.min(distArray[0].length(), distArray[distArray.length - 1].length());

            if ((maxGaps[1]  + 1 )/ 3 > (maxGaps[0] + 1 )/ 2) {
                minGap = Math.min(minGap, ( maxGaps[1] + 1) / 3);
            } else {
                if( boundaryArray[1] > minGap ){
                    minGap = Math.min(minGap, (maxGaps[1]  + 1 )/ 2);
                }else{
                    minGap = Math.min(minGap, (maxGaps[0]  + 1 )/ 2);
                }
            }

        }

        printWriter.println(minGap);
        printWriter.flush();
    }
}

import java.io.*;
import java.awt.Point;

public class BucketBrigade {
    public static void main(String[] args) throws Exception{
        int[][] matrix = new int[10][10];
        Point barn = null;
        Point rock = null;
        Point lake = null;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("buckets.in"));
        for( int i = 0; i < 10; i ++){
            String string = bufferedReader.readLine();
            if( string.indexOf("B") != -1 ){
                barn = new Point( string.indexOf("B"), i );
            }
            if( string.indexOf("R") != -1 ){
                rock = new Point( string.indexOf("R"), i );
            }
            if( string.indexOf("L") != -1 ){
                lake = new Point( string.indexOf("L"), i );
            }
        }

        int distance = Math.abs( barn.x - lake.x ) + Math.abs( barn.y - lake.y) - 1;

        if(   ( rock.x == barn.x && rock.x == lake.x) &&
              ( rock.y > Math.min(barn.y, lake.y) &&  rock.y < Math.max(barn.y, lake.y) )
              ){
            distance +=2;
        }
        else if(   ( rock.y == barn.y && rock.y == lake.y) &&
                ( rock.x > Math.min(barn.x, lake.x) &&  rock.x < Math.max(barn.x, lake.x) )
                ){
            distance +=2;
        }
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
        System.out.println(distance);
        printWriter.println(distance);
        printWriter.flush();
    }


}

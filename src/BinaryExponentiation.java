public class BinaryExponentiation
{

    static long binaryPowerMod(long a, long b, long m){
        long result = 1;
        while( b > 0 ){
            if( b == 1){
                result = result * a % m;
            }
            a = a * a % m;
            b = b /2;
        }
        return result;
    }

    static long binaryPower(long a, long b){
        long result = 1;
        while( b > 0 ){
            if( b == 1){
                System.out.print( result);
                result = result * a;
                System.out.println( "x" + a + " = " + result);
            }
            System.out.print(a + "x" + a + "=" );
            a = a * a;
            System.out.println(a);
            System.out.println( "b = " + b );
            b = b /2;
            System.out.println( "b = " + b );
        }
        return result;
    }

    public static void main(String[] args) {
        long res = binaryPower(3, 13);
        System.out.println("res = " + res);

        long resMod = binaryPowerMod(3, 13, 6500);
        System.out.println(resMod);

    }

}

package com.allan;

class GFG {

    static boolean isPerfectSquare(double x) {

        // Find floating point value of
        // square root of x.
        double sr = Math.sqrt(x);

        // If square root is an integer
        return ((sr - Math.floor(sr)) == 0);
    }

    static long myFormula(long x) {
        double y = 0;
        y = Math.pow(x, 4) + Math.pow(x, 3) + Math.pow(x, 2) + Math.pow(x, 1) + 1;
        System.out.println(x + ">" + (long) y );
        return (long)y;
    }

    // Driver code
    public static void main(String[] args) {
//        long k = 24457527;
//        long kk = (long)myFormula(k);
//        double m = Math.sqrt(kk);
//        System.out.println();
//        System.out.println(k);
//        System.out.println(kk);
//        System.out.println((long)kk);
//        System.out.println(m);
//        System.out.println((long)m);

        double maxNumber = 25000000;
        for (long i = 1; i < maxNumber; i++) {
            if (isPerfectSquare(myFormula(i))) {
                System.out.print("  yes ") ;
                System.out.print(i + "->" + myFormula(i)  );
                System.out.println();
            } else {
                //System.out.print("  no");
            }
        }

    }
}

package com.allan;

import java.io.BufferedReader;
import java.io.FileReader;

public class CowMoo {

    static String getMoo(int layer ){
        StringBuilder sb = new StringBuilder();
        if( layer == 0 ){
            return "moo";
        }
        else{
            sb.append(getMoo( layer -1));
            sb.append("moo");
            for( int i = 0 ; i< layer ; i++ ){
                sb.append("o");
            }
            sb.append(getMoo(layer -1));
        }

        return sb.toString();
    }

    static int getLayerLength(int layer){
        int length;
        if( layer == 0 ){
            length = 2;
        }
        else {
            length = layer + 3 + 2 * getLayerLength(layer -1 );
        }
        return length;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("moo.in"));
        int index = Integer.parseInt(br.readLine());

        int layer = 0;
        do{
        }
        while( getLayerLength(layer ++) < index + 1 );
        layer--;

        String result = getMoo(layer);
        System.out.println(result.charAt(index -1 ));




    }
}

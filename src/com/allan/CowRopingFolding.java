package com.allan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CowRopingFolding {

    static int[] knots;
    static TreeSet<Integer> foldingSet = new TreeSet<>();
    static int totalKnots;
    static int totalRopeLength;

    static void isMatching(int divider){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int countBegin = 0;
        int countEnd = 0;
        int count = 0;
        int medium = (knots[totalKnots/2 ] + knots[( totalKnots -1 ) /2]) / 2 ;
        boolean done = false;
        for( int i = 0; i< totalKnots  ; i++){
            if( knots[i] < divider ){
                stack.push(divider - knots[i]);
            }
            else if ( knots[i] > divider){
                if( !stack.isEmpty()){
                    if( ( knots[i] - divider ) != stack.pop()){
                        break;
                    } else if( stack.isEmpty() ){
                        foldingSet.add(divider);
                    }
                }
                else{
                    foldingSet.add(divider);
                    return;
                }
            }
        }
        stack.empty();
        for( int i = totalKnots -1 ; i >= 0 ; i--){
            if( knots[i] > divider ){
                stack2.push( knots[i] - divider);
            }
            else if ( knots[i] < divider){
                if( !stack2.isEmpty()){
                    if( divider - knots[i] != stack2.pop()){
                        break;
                    } else if( stack2.isEmpty() ){
                        foldingSet.add(divider);
                    }
                }
                else{
                    foldingSet.add(divider);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("foldering.in"));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        totalKnots = Integer.parseInt(stringTokenizer.nextToken());
        totalRopeLength = 2 * Integer.parseInt(stringTokenizer.nextToken());

        knots = new int[totalKnots];
        for( int i = 0; i < totalKnots; i++ ){
            knots[i] = 2 * Integer.parseInt(br.readLine());
        }
        Arrays.sort(knots);
        for( int i = 1; i < totalRopeLength; i ++){
            isMatching(i);
        }
        System.out.println(foldingSet.size());
    }
}

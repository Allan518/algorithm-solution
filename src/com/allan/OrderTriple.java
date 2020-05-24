package com.allan;

import java.util.*;

public class OrderTriple {

    public static void main(String[] args) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (i != j && j != k && i != k){
                        int y = i * 100 + j * 10 + k;
                        numSet.add(Integer.valueOf(y));
                    }
                }
            }
        }
        TreeSet treeSet = new TreeSet(numSet);

        Iterator<Integer> it = treeSet.iterator();
        int i = 1;
        Integer startNum = it.next();
        Set<Integer> tmpSet = new HashSet<Integer>();
        tmpSet.add(startNum);
        int count = 1;
        while (it.hasNext()) {
            System.out.print(" " + i++ + " ");
            Integer n = it.next();
            if ( startNum.intValue() % 100 == n.intValue()/10 ){
                tmpSet.add(n);
                treeSet.remove(n);
                startNum = n;
                count++;
                System.out.print( " " + n + ", ");
            }
            System.out.println(n);
        }
        System.out.println(count);
    }
}


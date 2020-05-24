package com.allan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class CowConnect {
    static int getDirection(int x1, int y1, int x2, int y2) {
        int direction = 0;
        if (x1 != x2 && y1 != y2) {
            return -1;
        } else if (x2 > x1) {
            direction = 1;
        } else if (x2 < x1) {
            direction = 2;
        } else if (y2 > y1) {
            direction = 3;
        } else if (y2 < y1) {
            direction = 4;
        }
        return direction;
    }

    static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    static void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int[] arr) {
        if (resultList.size() == arr.length) {
            list.add(new ArrayList<>(resultList));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (resultList.contains(arr[i])) {
                    continue;
                }
                resultList.add(arr[i]);
                permuteHelper(list, resultList, arr);
                resultList.remove(resultList.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        long x = System.currentTimeMillis();
        BufferedReader sb = new BufferedReader(new FileReader("connect.in"));
        int totalDots = Integer.parseInt(sb.readLine());

        int[][] dotMatrix = new int[totalDots][2];
        int[] arr = new int[totalDots];
        for (int i = 0; i < totalDots; i++) {
            arr[i] = i;
            StringTokenizer st = new StringTokenizer(sb.readLine());
            dotMatrix[i][0] = Integer.parseInt(st.nextToken());
            dotMatrix[i][1] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> permute = permute(arr);
        int count = 0;
        boolean skip = false;
        for (List<Integer> perm : permute) {
            skip = false;
            int startingDot = perm.get(0);
            Stack<Integer> dirStack = new Stack<>();
            int dir = getDirection(0, 0, dotMatrix[startingDot][0], dotMatrix[startingDot][1]);
            if (dir == -1) {
                continue;
            } else {
                dirStack.push(dir);
            }
            for (int i = 0; i < perm.size() - 1; i++) {
                int thisDot = perm.get(i);
                int nextDot = perm.get(i + 1);
                int thisDir = getDirection(dotMatrix[thisDot][0], dotMatrix[thisDot][1], dotMatrix[nextDot][0], dotMatrix[nextDot][1]);
                if (thisDir == -1) {
                    skip = true;
                    break;
                }
                if (thisDir == dirStack.pop()) {
                    skip = true;
                    break;
                } else {
                    dirStack.push(thisDir);
                }
            }
            if (!skip) {
                int lastDot = perm.get(perm.size() - 1);
                dir = getDirection(dotMatrix[lastDot][0], dotMatrix[lastDot][1], 0, 0);
                if ( dir == dirStack.pop() || dir == -1 ) {
                    continue;
                } else {
                    System.out.println("good " + perm);
                    count++;
                }
            }
        }
        System.out.println(count);
        long y = System.currentTimeMillis();
        System.out.println(y -x);
    }
}



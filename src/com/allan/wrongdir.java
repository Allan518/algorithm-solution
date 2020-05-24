package com.allan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.valueOf(x) + "," + String.valueOf(y);
    }
}

public class wrongdir {
    static String originalInstructionString = null;
    static HashSet<String> finalDesination = new HashSet<>();
    static Point[] offsetsAccumulated = null;
    static Point[] pointListCoordinates = null;  //this position of each original point
    static int currentDirection = 1;
    //Up 0, //Left 1 // Right 2

    static void setPointListCoordinates(String dirString) {
        Point currentP = new Point(0,0);
        pointListCoordinates = new Point[dirString.length()];
        for (int i = 0; i < dirString.length(); i++) {
            pointListCoordinates[i] = new Point(0, 0);
            if (dirString.charAt(i) == 'F') {
                if( i == 0 ) {
                    pointListCoordinates[0].x = 0;
                    pointListCoordinates[0].y = 1;
                }
                else{
                    if( currentDirection == 0 ){ //up
                        pointListCoordinates[i].x = pointListCoordinates[i-1].x;
                        pointListCoordinates[i].y = pointListCoordinates[i-1 ].y + 1;
                    }else if ( currentDirection == 1){ //left
                        pointListCoordinates[i].x = pointListCoordinates[i-1].x -1 ;
                        pointListCoordinates[i].y = pointListCoordinates[i-1 ].y ;
                    } else {//right
                        pointListCoordinates[i].x = pointListCoordinates[i-1].x + 1 ;
                        pointListCoordinates[i].y = pointListCoordinates[i-1 ].y ;
                    }
                }
            } else if (dirString.charAt(i) == 'L') {
                currentDirection = 1;
                if( i > 0 ) {
                    pointListCoordinates[i].x = pointListCoordinates[i-1].x;
                    pointListCoordinates[i].y = pointListCoordinates[i-1].y;
                }
            } else if (dirString.charAt(i) == 'R') {
                currentDirection = 2;
                if( i > 0 ) {
                    pointListCoordinates[i].x = pointListCoordinates[i-1].x;
                    pointListCoordinates[i].y = pointListCoordinates[i-1 ].y ;
                }
            }
        }
    }
    static Point nextPoint(Point inputP , int dir){
        Point thisP = new Point(0,0);
        if( dir == 1 ){
            thisP.x = inputP.x;
            thisP.y = inputP.y + 1;
        }else if( dir == 2 ){

        }else if ( dir == 3){

        }
        return thisP; // need revisit
    }

    static void addFinalDestination(Point thisPoint, int i) {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 0);
        if (originalInstructionString.charAt(i) == 'F') {
            pointA.x = thisPoint.x - 1 + offsetsAccumulated[i + 1].x;
            pointA.y = thisPoint.y - 1 + offsetsAccumulated[i + 1].y;
            pointB.x = thisPoint.x + 1 + offsetsAccumulated[i + 1].x;
            pointB.y = thisPoint.y - 1 + offsetsAccumulated[i + 1].y;
        } else if (originalInstructionString.charAt(i) == 'L') {
            pointA.x = thisPoint.x + 1 + offsetsAccumulated[i + 1].x;
            pointA.y = thisPoint.y + 1 + offsetsAccumulated[i + 1].y;
            pointB.x = thisPoint.x + 1 + 1 + offsetsAccumulated[i + 1].x;
            pointB.y = thisPoint.y + offsetsAccumulated[i + 1].y;
        } else if (originalInstructionString.charAt(i) == 'R') {
            pointA.x = thisPoint.x - 1 + offsetsAccumulated[i + 1].x;
            pointA.y = thisPoint.y + 1 + offsetsAccumulated[i + 1].y;
            pointB.x = thisPoint.x - 1 - 1 + offsetsAccumulated[i + 1].x;
            pointB.y = thisPoint.y + offsetsAccumulated[i + 1].y;
        }
        finalDesination.add(pointA.toString());
        finalDesination.add(pointB.toString());
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("wrongdir.in"));
        originalInstructionString = br.readLine();

        int allDirLength = originalInstructionString.length();
        pointListCoordinates = new Point[allDirLength];
        setPointListCoordinates(originalInstructionString);

        Point[] offsets = new Point[allDirLength];
        offsetsAccumulated = new Point[allDirLength + 1];
        offsetsAccumulated[allDirLength] = new Point(0, 0);

        for (int i = allDirLength - 1; i >= 0; i--) {
            char thisDir = originalInstructionString.charAt(i);
            offsets[i] = new Point(0, 0);
            offsets[i].x = pointListCoordinates[allDirLength-1].x - pointListCoordinates[i].x;
            offsets[i].y = pointListCoordinates[allDirLength-1].y - pointListCoordinates[i].y;
        }

        Point[] currentPoint = new Point[allDirLength];
        for (int i = 0; i < allDirLength; i++) {
            currentPoint[i] = new Point(0, 0);
            char currDir = originalInstructionString.charAt(i);
            if (i == 0) {
                if (currDir == 'F') {
                    currentPoint[i].x = 0;
                    currentPoint[i].y = 1;
                    currentDirection = 0;
                } else if (currDir == 'L') {
                    currentDirection = 1;
                } else if (currDir == 'R') {
                    currentDirection = 2;
                }
            } else {
                if (currDir == 'F') {
                    currentPoint[i].x = 0 + currentPoint[i - 1].x;
                    currentPoint[i].y = 1 + currentPoint[i - 1].y;
                } else if (currDir == 'L') {
                    currentPoint[i].x = -1 + currentPoint[i - 1].x;
                    currentPoint[i].y = 0 + currentPoint[i - 1].y;
                } else if (currDir == 'R') {
                    currentPoint[i].x = 1 + currentPoint[i - 1].x;
                    currentPoint[i].y = 0 + currentPoint[i - 1].y;
                }
            }
            addFinalDestination(currentPoint[i], i);
        }
        System.out.println(finalDesination.size());
    }
}

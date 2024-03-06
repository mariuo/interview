package com.company.codingGame;

import java.util.Scanner;
/*
Write a program that prints the temperature closest to 0 among input data. If two numbers are equally close to zero, positive integer has to be considered closest to zero (for instance, if the temperatures are -5 and 5, then display 5).
 	Game Input
Your program must read the data from the standard input and write the result on the standard output.
Input
Line 1: N, the number of temperatures to analyze

Line 2: A string with the N temperatures expressed as integers ranging from -273 to 5526

Output
Display 0 (zero) if no temperatures are provided. Otherwise, display the temperature closest to 0.
Constraints
0 ≤ N < 10000
Example
Input
5
1 -2 -8 4 5
Output
1
 */
public class ClosestTempToZero {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        //System.err.println("hei "+ n);
        if(n == 0 ) {
            System.out.println(0);
        }
        else{
            int cloTemp = 5526;

            for (int i = 0; i < n; i++) {
                int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526

                if(t <= -273) cloTemp = -273;
                if(t >= 5526) cloTemp = 5526;

                for(int x = 1 ; x < n ; x++){
                    if((cloTemp + t == 0) && (cloTemp < 0)) cloTemp = Math.abs(cloTemp);
                    if(Math.abs(t) < Math.abs(cloTemp)){
                        cloTemp = t;

                    }
                }


                // Write an answer using System.out.println()
                // To debug: System.err.println("Debug messages...");


            }

            System.out.println(cloTemp);
            }
        }

}

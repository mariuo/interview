package com.company.codingGame;

import java.util.Scanner;


/*
Within an infinite loop, read the heights of the mountains from the standard input and print to the standard output the index of the mountain to shoot.
Input for one game turn
8 lines: one integer mountainH per line. Each represents the height of one mountain given in the order of their index (from 0 to 7).
Output for one game turn
A single line with one integer for the index of which mountain to shoot.
Constraints
0 ≤ mountainH ≤ 9
Response time per turn ≤ 100ms

 */
public class TheDescent {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Integer[] arr = new Integer[8];


        while (true) {
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.
                // System.err.println(mountainH);
                // System.out.println(mountainH);
                arr[i] = mountainH;
            }
            int highestIndex = 0;
            int highestM = arr[0];
            for (int i = 1; i < arr.length; i++){
                if (arr[i] > highestM){
                    highestM = arr[i];
                    highestIndex = i;

                }

            }

            System.out.println(highestIndex);


            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


        }
    }
}

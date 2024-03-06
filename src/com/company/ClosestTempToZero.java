package com.company;

import java.util.Scanner;

public class ClosestTempToZero {
        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt(); // the number of temperatures to analyse
            //System.err.println("hei "+ n);
            if(n == 0 ) {
                System.out.println(0);
            }
            else{
                int cloTemp = Integer.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526


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

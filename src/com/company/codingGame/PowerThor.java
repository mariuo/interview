package com.company.codingGame;

import java.util.Scanner;

/*
Your program must allow Thor to reach the light of power.
 	Rules
Thor moves on a map which is 40 wide by 18 high. Note that the coordinates (X and Y) start at the top left! This means the most top left cell has the coordinates "X=0,Y=0" and the most bottom right one has the coordinates "X=39,Y=17".

Once the program starts you are given:
the variable lightX: the X position of the light of power that Thor must reach.
the variable lightY: the Y position of the light of power that Thor must reach.
the variable initialTX: the starting X position of Thor.
the variable initialTY: the starting Y position of Thor.
At the end of the game turn, you must output the direction in which you want Thor to go among:

N (North)
NE (North-East)
E (East)
SE (South-East)
S (South)
SW (South-West)
W (West)
NW (North-West)
 */
public class PowerThor {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String result = "";
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position
        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
            // System.err.println(remainingTurns);


            if(lightX > 0 && lightX < 40){

            }
            int stepX =0, stepY =0;
            if(initialTx < lightX) {
                initialTx++;
                stepX++;
            }else if(initialTx > lightX){
                initialTx--;
                stepX--;
            }

            if(initialTy < lightY) {
                initialTy++;
                stepY++;
            }else if(initialTy > lightY){
                initialTy--;
                stepY--;
            }
            result = getDirection(stepX,stepY);

            System.out.println(result);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // A single line providing the move to be made: N NE E SE S SW W or NW

            // System.out.println("SE");
        }
    }
    public static String getDirection(int x, int y){
        String result = "";
        if (y >0){
            result += "S"; // goes to right
        }else if( y < 0){
            result += "N";
        }
        if (x > 0){
            result += "E"; // goes to right
        }else if( x < 0){
            result += "W";
        }
        return result;

    }
}

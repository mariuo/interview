package com.company;

public class HourConverstion {
    public static void main(String[] args) {
        System.out.println(timeConversion("01:01:00AM"));
    }
    public static String timeConversion(String s) {
        // Write your code here

        String pre = s.substring(0,2);
        String mid = s.substring(3,8);
        String pos = s.substring(8);

        // System.out.println(pre);
        // System.out.println(mid);
        // System.out.println(pos);
        int preI = 00;
        String result ="";
        if(pos.equals("PM")){
            preI = Integer.valueOf(pre);
            if(preI == 12){
                preI = 12;
            }else{
                preI = preI + 12;
            }
             result = "" + preI + ":" + mid;
        }
        else if (pos.equals("AM")){
            preI = Integer.valueOf(pre);
            if(preI == 12){
                preI = 00;
            }
             result = "0" + preI + ":" + mid;
        }
        return result;

    }
}


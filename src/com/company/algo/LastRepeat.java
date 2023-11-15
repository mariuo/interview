package com.company.algo;

import java.util.HashSet;
/**
        Algo: Last Repeated Character

        Given a string of characters, find the last repeated character.

        Example A
        Input: "abbc"
        Output: "b"

        Example B
        Input: "abracadabra"
        Output: "a"

        Follow-up Questions:
        - Describe your solution briefly.
        - Could you estimate the complexity of your solution?
        - In which conditions could this solution fail?
        - Given time, what would you improve?

 */
public class LastRepeat {
    public static void main(String[] args) {
        var in = "Countdown";
        var out = lastRepeat(in);
        System.out.println(out);
    }
    public static String lastRepeat(String in){
        if(in == null) {
            return "";
        }
        var result = "";
        var repeat = new HashSet<Character>();
        for(int i = 0;  i< in.length(); i++){
            var c = in.charAt(i);
            //If the char already exists in the Set, UPDATE.
            if(repeat.contains(c)){
                result = c + "";
            }else{
                repeat.add(c);
            }
        }


        return result;
    }
}

package com.company.leetcode;
/*
557. Reverse Words in a String III

Given an string s, reverse the order of chars in each word whithing
a sentence while still preserving whitespace and initial word order.

 */
public class ReverseWordsInSeq {
    public static void main(String[] args) {
        // Test case 1
        String s1 = "the sky is blue";
        System.out.println(reverseWords(s1)); // Expected: "eht yks si eulb"
    }
    static String reverseWords(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        int l = 0, r = 0;
        while(r < s.length()){
            if(s.charAt(r) != ' '){
                r++;
            }else{
                res.append(new StringBuilder(s.substring(l, r + 1)).reverse());
                r++;
                l=r;
            }
        }
        res.append(" ");
        res.append(new StringBuilder(s.substring(l, Math.min(r + 2, s.length()))).reverse());

        return res.substring(1);

    }
}

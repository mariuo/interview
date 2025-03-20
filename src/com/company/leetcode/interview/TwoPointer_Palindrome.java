package com.company.leetcode.interview;
/*
125. Valid Palindrome
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

 */
public class TwoPointer_Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("ama"));
    }
    static boolean isPalindrome(String s){
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }else if(s.toLowerCase().charAt(l) == s.toLowerCase().charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}

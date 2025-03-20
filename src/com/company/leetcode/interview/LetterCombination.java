package com.company.leetcode.interview;

/*
17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
2=[a,b,c]
3=[d,e,f]
4=[g,h,i]
5=[j,k,l]
6=[m,n,o]
7=[p,q,r,s]
8=[t,u,v]
9=[w,x,y,z]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

import java.util.*;

public class LetterCombination {
    private static final String[] PHONE_KEYBOARD = {
            "", "", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        backtrack(new StringBuilder(), digits, 0, res);
        return res;
    }

    static void backtrack(StringBuilder sb, String digits, int index, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = PHONE_KEYBOARD[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            sb.append(letter);
            backtrack(sb, digits, index + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
       System.out.println(letterCombinations("23")); // Expected output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    }
}

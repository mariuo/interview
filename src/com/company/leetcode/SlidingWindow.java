package com.company.leetcode;

import java.util.HashMap;

/*
Leetcode 3090. Maximum length substring with two occurrences of each character.
Given a string s, return the maximum length of a substring that contains at most two distinct characters.

Example 1:
input s = "bcbbbcba"
output: 4

Example 2:
input s = "aaaa"
output: 2
The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".\

Constraints:
2<= s.length <= 100
s consists of English letters.
 */
public class SlidingWindow {
    public static void main(String[] args) {
        // Test case 1
        String s1 = "bcbbbcba";
        System.out.println(maxLength(s1)); // Expected: 4

        // Test case 2
        String s2 = "aaaa";
        System.out.println(maxLength(s2)); // Expected: 2
    }
    static int maxLength(String s) {
        int l = 0;
        int r = 0;
        int maxLen = 1;
        HashMap<Character, Integer> counter = new HashMap<>();
        counter.put(s.charAt(0), 1);

        while (r < s.length() - 1) {
            r++;
            counter.put(s.charAt(r), counter.getOrDefault(s.charAt(r), 0) + 1);
            while (counter.get(s.charAt(r)) == 3) {
                counter.put(s.charAt(l), counter.get(s.charAt(l)) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}


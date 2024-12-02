package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 */
public class LongestSubStringNoRep {
    public static void main(String[] args) {
        System.out.println(checkString("abcabcbb"));
        System.out.println(checkString("bbbbbabcdaefg"));
        System.out.println(lengthOfLongestSubstring("bbbbbabcdaefg"));
        System.out.println(checkString("pwwkew"));
    }
    static int checkString(String s){
        if (s == null) return 0;

        int maxLen = 0;
        int l = 0;  // Start of the window
        HashSet<Character> set = new HashSet<>();

        for(int r = 0;  r< s.length(); r++){
            char c = s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> ls = new HashMap<>();
        int end=0,start=0,result=0;
        for(Character c:s.toCharArray())
        {
            if(ls.containsKey(c))
            {
                start=Math.max(start,ls.get(c)+1);
            }
            ls.put(c,end);
            end++;
            result=Math.max(result,end-start);
        }
        return result;
    }
}

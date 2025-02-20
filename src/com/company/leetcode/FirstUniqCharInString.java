package com.company.leetcode;

import java.util.HashMap;

/*
387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 Example 1:
 input: s= "leetcode"
 output: 0
 The char 'l' at index 0 is the first char that does not occur at any other index.

 Example 2:
 input: s= "loveleetcode"
 output: 2

 Example 3:
 input: s= "aabb"
 output: -1

 Constraints:
 1 <= s.length <= 10^5
 s consists of only lowercase English letters.
 */
public class FirstUniqCharInString {

    public static void main(String[] args) {
        // Test case 1
        String s1 = "leetcode";
        System.out.println(firstUniqChar(s1)); // Expected: 0

        // Test case 2
        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s2)); // Expected: 2

        // Test case 3
        String s3 = "aabb";
        System.out.println(firstUniqChar(s3)); // Expected: -1
    }
    static int firstUniqChar(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            var c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

    }
}

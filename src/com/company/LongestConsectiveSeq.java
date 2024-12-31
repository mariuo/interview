package com.company;

import java.util.HashSet;


public class LongestConsectiveSeq {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsec(nums));
    }
    static int longestConsec(int[] nums){

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Add all numbers to a HashSet
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // Step 2: Iterate and find the longest sequence
        int longestStreak = 0;

        for (int num : numSet) {
            // Only check for the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;

    }
}

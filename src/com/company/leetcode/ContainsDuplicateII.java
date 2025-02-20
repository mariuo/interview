package com.company.leetcode;

import java.util.HashMap;

/*
219. Contains Duplicate II
Given an integer array nums and an integer k, return true if there are
two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
input nums = [1,2,3,1], k = 3
output: true

Example 2:
input nums = [1,0,1,1], k = 1
output: true

Example 3:
input: nums = [1,2,3,1,2,3], k = 2
output: false

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println(containsNearbyDuplicate(nums1, k1)); // Expected: true

        // Test case 2
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(containsNearbyDuplicate(nums2, k2)); // Expected: true

        // Test case 3
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(containsNearbyDuplicate(nums3, k3)); // Expected: false
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;

    }
}

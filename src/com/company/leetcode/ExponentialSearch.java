package com.company.leetcode;

public class ExponentialSearch {
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target1 = 5;
        System.out.println(exponentialSearch(nums1, target1)); // Expected: 4

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target2 = 10;
        System.out.println(exponentialSearch(nums2, target2)); // Expected: -1

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target3 = 1;
        System.out.println(exponentialSearch(nums3, target3)); // Expected: 0

        // Test case 4
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target4 = 9;
        System.out.println(exponentialSearch(nums4, target4)); // Expected: 8

    }
    static int exponentialSearch(int[] nums, int target){
        if(nums[0] == target){
            return 0;
        }

        int i = 1;
        while(i < nums.length && nums[i] <= target){
            i *= 2;
        }

        return binarySearch(nums, target, i / 2, Math.min(i, nums.length - 1));
    }
    static int binarySearch(int[] nums, int target, int left, int right){
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }
}

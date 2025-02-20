package com.company.leetcode;


public class BinarySearch {
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target1 = 5;
        System.out.println(binarySearch(nums1, target1)); // Expected: 4

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target2 = 10;
        System.out.println(binarySearch(nums2, target2)); // Expected: -1

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target3 = 1;
        System.out.println(binarySearch(nums3, target3)); // Expected: 0

        // Test case 4
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target4 = 9;
        System.out.println(binarySearch(nums4, target4)); // Expected: 8
    }
    static int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

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

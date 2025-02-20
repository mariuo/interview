package com.company.leetcode.sorts;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int[] nums = bubbleSort(arr);
        for(int num : nums){
            System.out.print(num);
        }
    }

    static int[] bubbleSort(int[] nums){
        for(int num : nums){
            for(int i =0; i< nums.length -1; i++){
                if(nums[i] < nums[i+1]){
                    var temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }
        return nums;

    }
}

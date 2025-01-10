package com.company.algo;

import java.util.HashMap;

public class SumTwo {
    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int expect = 9;

        int[] result = twoSum(input, expect);
        for(int i : result){
            System.out.println(i);
        }
    }
    static int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;

    }
}

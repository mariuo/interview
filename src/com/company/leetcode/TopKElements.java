package com.company.leetcode;

import java.util.*;

/*
Create a map, with the value and occurrences as key, value pair
Somehow sort according to the descending order of their occurrences and also include these cases, if you wish to
Case1. if two elements have same occurrences print the elements lexicographically(if strings) or ascending order of the numbers(if integers)
Case 2: if the occurrences are distinct, print in descending order of the occurrences of the elements.
Return the first K elements.
 */
public class TopKElements {
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = topKelements(nums1, k1);
        System.out.println("Test Case 1: " + Arrays.toString(result1)); // Expected: [1, 2]

        // Test case 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = topKelements(nums2, k2);
        System.out.println("Test Case 2: " + Arrays.toString(result2)); // Expected: [1]

        // Test case 3
        int[] nums3 = {4, 4, 4, 4, 3, 3, 2, 1};
        int k3 = 3;
        int[] result3 = topKelements(nums3, k3);
        System.out.println("Test Case 3: " + Arrays.toString(result3)); // Expected: [4, 3, 2] (order may vary)

        // Test case 4
        int[] nums4 = {5, 7, 5, 7, 5, 8};
        int k4 = 2;
        int[] result4 = topKelements(nums4, k4);
        System.out.println("Test Case 4: " + Arrays.toString(result4)); // Expected: [5, 7] (order may vary)
    }

    static int[] topKelements(int[] nums, int k){
        // Step 1: Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets.get(freq).add(num);
        }

        // Step 3: Collect top K frequent elements
        int[] result = new int[k];
        int index = 0;
        for (int freq = buckets.size() - 1; freq > 0; freq--) {
            for (int num : buckets.get(freq)) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}

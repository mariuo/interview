package com.company.algo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Two Number Sum
 *
 * Given a list of numbers, find the first pair that sums up to a given target.
 *
 * Write a function that takes in a non-empty array of distinct integers and an
 * integer representing a target sum. If any two numbers in the input array sum
 * up to the target sum, the function should return them in an array, in any
 * order. If no two numbers sum up to the target sum, the function should return
 * an empty array.
 *
 * Note that the target sum has to be obtained by summing two different integers
 * in the array; you can't add a single integer to itself in order to obtain the
 * target sum.
 *
 * You can assume that there will be at most one pair of numbers summing up to
 * the target sum.
 *
 * Sample Input
 * array = [3, 5, -4, 8, 11, 1, -1, 6]
 * targetSum = 10
 *
 * Sample Output
 *  [-1, 11] // the numbers could be in reverse order
 */
public class PairSum {
    public static void main(String[] args) {
        int[] input = {3, 5, -4, 8, 11, 1, -1, 6, 2};
        int expect = 10;

        int[] result = sumLeftToRight(input, expect);
        for(int i : result){
            System.out.println(i);
        }

    }

    public static int[] sumLeftToRight(int[] arr, int expect){
        if(arr == null) return null;
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length -1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == expect){
                return new int[]{arr[left], arr[right]};
            }else if (sum < expect) {
                left++;
            }else{
                right++;
            }
        }
        return null;

    }
}

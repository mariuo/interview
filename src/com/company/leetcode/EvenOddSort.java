package com.company.leetcode;

import java.util.Arrays;

public class EvenOddSort {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,5,6,9,8};
        sortEvenOdd(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void sortEvenOdd(int[] arr) {
        int left = 0, right = 0;

        while(right < arr.length){
            if(arr[right] % 2 == 0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            right++;
        }
    }

}

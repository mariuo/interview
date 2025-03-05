package com.company.leetcode.sorts;

/*
MergeSort
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,1,4};
        mergeSort(arr, 0, arr.length-1);
        for(int num : arr){
            System.out.print(num);
        }
    }

    private static void mergeSort(int[] arr, int i, int i1) {
    }

}

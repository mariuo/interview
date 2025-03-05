package com.company.leetcode.sorts;

/*
QUICKSORT Divide and Conquer
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,1,4};
        quickSort(arr, 0, arr.length-1);
        for(int num : arr){
            System.out.print(num);
        }
    }
    static void quickSort(int[] arr, int left, int right){
        if(left < right){
            var posPivot = partition(arr, left, right);
            quickSort(arr, left, posPivot -1);
            quickSort(arr, right, posPivot + 1);
        }
    }
    static int partition(int[] arr, int left, int right){
        var pivot = arr[right];
        var i = left-1;
        for(int l = left; l < right; l++){
            if(arr[l] < pivot){
                i++;
                change(arr,i,l);
            }
        }
        change(arr, i + 1, right);
        return i + 1;
    }
    static void change(int[] arr, int i, int j){
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

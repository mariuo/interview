package com.company.interview;

/*
Find the MAX second INT from Array.
 */
public class SecondBigger {
    public static void main(String[] args) {
        int[] arr = {3,2,1,6,5,4};
        System.out.println(secondMax(arr));
    }
    // 6
    //
    static int secondMax(int[] arr){
        var maxFirst = Integer.MIN_VALUE;
        int i= 0;
        var maxSec = maxFirst;
        while(i<arr.length){
            if(arr[i] >= maxFirst){
                maxSec = maxFirst;
                maxFirst = arr[i];
            }else if(arr[i] > maxSec && arr[i] != maxFirst){
                maxSec = arr[i];
            }
            i++;
        }
        return maxSec;
    }
}

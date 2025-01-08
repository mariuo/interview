package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingNumbersLongestSubarray {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(4, 6, 5, 3, 3, 1));
        List<Integer> b = new ArrayList<>(Arrays.asList(1,2,2,1,2));

        System.out.println(pickingNumbers(a));
        System.out.println(pickingNumbers2(b));
    }

    public static int pickingNumbers(List<Integer> a) {
        int[] freq = new int[101];
        for (int num : a) {
            freq[num]++;
        }
        int result = 0;
        for (int i = 1; i < 101; i++) {
            result = Math.max(result, freq[i] + freq[i - 1]);
        }
        return result;
    }
    public static int pickingNumbers2(List<Integer> b){
        Collections.sort(b);
        int maxLen=0;
        int left=0, right=0;
        while(right<b.size()){
            if(b.get(right)-b.get(left)<=1){
                maxLen=Math.max(maxLen, right-left+1);
                right++;
            }else{
                left++;
            }
        }
        return maxLen;
    }

}

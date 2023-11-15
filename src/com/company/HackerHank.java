package com.company;

import java.util.*;



    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */
public class HackerHank {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList<Integer>();
        x.add(1);
        x.add(2);
        x.add(1);
        x.add(3);
        x.add(2);
        System.out.println(birthday(x, 4,3));




//        x.add(4);
//        System.out.println(birthday(x, 4,1));

    }

        public static int socksMerchantt(int n, List<Integer> ar){
            n= 0;
            Set<Integer> mySet = new HashSet<Integer>(ar); //Array of socks to Hash set
            for(int s : mySet){
                //identify frecuency of each color and add the pair to the counter
                n+=(Collections.frequency(ar, s))/2;
            }
            return n;
        }
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        if (d == 0 || m == 0 || s.size() == 0) {
            return 0;
        }
        int[] array = new int[s.size()];
        for (int i = 0; i < s.size(); i++)
            array[i] = s.get(i);
        int sum = 0;
        int result = 0;
        int arrSize = array.length;
        if ((m == 1) && (arrSize == 1) && (d == array[0])) {
            result = 1;
        } else if ((m == 1) && (arrSize > 1)) {
            for (int y = 0; y < arrSize; y++) {
                if (d == array[y]) {
                    result = result + 1;
                }
            }
        } else if (m > 1) {
            List<Integer> bar = new ArrayList<>();
            for (int i = 0; i < s.size(); i++) {
                if (i + m <= s.size()) {
                    bar = s.subList(i, i + m);
                    System.out.println(bar.get(0) + " " + bar.get(1));
                    sum = 0;
                    for (int j : bar) {
                        sum += j;
                    }
                    if (sum == d) {
                        result++;
                    }
                }
            }


        }
        return result;

    }
}

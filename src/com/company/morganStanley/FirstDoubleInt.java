package com.company.morganStanley;


//Dans une liste d'Integers, trouver le premier nombre en double:

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FirstDoubleInt {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 5, -4, 3, 11, 1, -1, 5, 2);
        int result = firstDoubleInt(input);
        System.out.println(result);
    }

    private static int firstDoubleInt(List<Integer> input) {
        if(input == null) return 0;
        HashSet<Integer> firstDouble = new HashSet<>();
        return input.stream().filter(i -> !firstDouble.add(i)).findFirst().orElse(null);
    }
}

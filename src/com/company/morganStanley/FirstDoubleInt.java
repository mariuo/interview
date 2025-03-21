package com.company.morganStanley;


//Dans une liste d'Integers, trouver le premier nombre en double:

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstDoubleInt {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 5, -4, 3, 11, 1, -1, 5, 2);
        int result = firstDoubleInt(input);
        System.out.println(result);
        int result2 = findFirstDuplicate(input);
        System.out.println(result2);
    }

    private static int firstDoubleInt(List<Integer> input) {
        if(input == null) return 0;
        HashSet<Integer> firstDouble = new HashSet<>();
        return input.stream().filter(i -> !firstDouble.add(i)).findFirst().orElse(null);
    }


        public static Integer findFirstDuplicate(List<Integer> numbers) {
            Set<Integer> seen = new HashSet<>();
            for (Integer num : numbers) {
                if (!seen.add(num)) { // Si l'ajout échoue, c'est un doublon
                    return num;
                }
            }
            return null; // Aucun doublon trouvé
        }

}

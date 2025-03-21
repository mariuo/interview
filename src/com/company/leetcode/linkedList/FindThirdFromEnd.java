package com.company.leetcode.linkedList;

import java.util.LinkedList;

public class FindThirdFromEnd {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);

        System.out.println(findThirdFromEnd(list)); // Doit afficher 50
    }

    public static <T> T findThirdFromEnd(LinkedList<T> list) {
        if (list == null || list.size() < 3) {
            throw new IllegalArgumentException("La liste doit avoir au moins 3 éléments");
        }

        var first = list.listIterator(3); // Premier pointeur avance de 3
        var second = list.listIterator(); // Second commence au début

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next(); // Retourne l'élément trouvé
    }
}
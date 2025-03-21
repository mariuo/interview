package com.company.morganStanley;

public class ReverseWords {
    public static void main(String[] args) {
        String sentence = "world Hello";
        System.out.println(reverseWords(sentence)); // "Hello world"
    }

    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) return sentence;

        String[] words = sentence.split("\\s+"); // Sépare sur les espaces
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        return reversed.toString().trim(); // Supprime l'espace final
    }
}

package com.company;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        String str1 = "amor";
        String str2 = "romA";

        System.out.println((isAnagramSort(str1, str2)) ? " Is an anagram " : " Is not an anagram");
        System.out.println((isAnagramCounting(str1, str2)) ? " Is an anagram " : " Is not an anagram");
        System.out.println((isAnagrasmXOR(str1, str2)) ? " Is an anagram " : " Is not an anagram");

    }

    public static boolean isAnagrasmXOR(String string1, String string2) {
        int r = 0;
        if (string1.length() != string2.length()) {
            return false;
        }
        for (int i = 0; i < string1.length(); i++)
            r = r ^ string1.length();

        for (int i = 0; i < string2.length(); i++)
            r = r ^ string2.length();

        return (r == 0);

    }

    public static boolean isAnagramSort(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        char[] a1 = string1.toCharArray();
        char[] a2 = string2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    private static int CHARACTER_RANGE = 256;

    public static boolean isAnagramCounting(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        int count[] = new int[CHARACTER_RANGE];
        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            System.out.println(count[string1.charAt(i)]);
            count[string2.charAt(i)]--;
            System.out.println(count[string1.charAt(i)]);
        }
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

}

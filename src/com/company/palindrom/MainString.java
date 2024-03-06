package com.company.palindrom;

public class MainString {
    public static void main(String[] args) {
        String str = "AbcddcbA";

        System.out.println(isPalindrome(str));
//        System.out.println(str.substring(2));

    }
    static boolean isPalindrome(String str){
        if(str == null) return false;

        int mid = str.length()/2;
        String strA = str.substring(0, mid);

        String strB = str.substring(mid);
        // et reverser l'autre moit
        String revB = new StringBuilder(strB).reverse().toString();

        if(strA.equals(revB)){
            return true;

        }else return false;

    }
}

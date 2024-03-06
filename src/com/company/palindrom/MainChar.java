package com.company.palindrom;

public class MainChar {
    public static void main(String[] args) {
        char[] palin = {'a', 'b', 'C', 'C', 'b', 'a'};

        System.out.println(isPalindrome(palin));

    }
    static boolean isPalindrome(char[] palin){
        boolean result = false;
        for (int i = 0 ; i<palin.length / 2; i++){
            System.out.println(i);
            if (palin[i] == palin[palin.length - i - 1]) {
                result = true;
            }else{
                result = false;
            }
        }
        return result;
    }
}

package com.company.palindrom;

public class MainChar {
    public static void main(String[] args) {
        char[] palin = {'a', 'b', 'C', 'C', 'b', 'a'};

//        System.out.println(isPalindrome(palin));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(0));

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
    static boolean isPalindrome(int x) {
        if (x <0 || (x!= 0 && x % 10 == 0)) return false;
        String str = x + "";
        int s = str.length();
        boolean resu = false;
        for(int i = 0; i < s/2; i++){
            if(str.charAt(i) != str.charAt(s - i - 1)) resu = false;
            else resu = true;
        }
        return resu;
    }
}

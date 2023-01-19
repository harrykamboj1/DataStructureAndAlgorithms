package com.dsAlgo.Strings;

public class PalindromeNumber {
    public static void main(String[] args) {
        String str = "abcdCba";
        System.out.println(isPalindrome(str));
    }
    private static boolean isPalindrome(String str) {
        if(str==null || str.length()==0){
            return false;
        }
        str = str.toLowerCase();

        for (int i = 0; i <= str.length()/2 ; i++) {
            int start = str.charAt(i);
            int end = str.charAt(str.length()-1-i);
            if(start != end){
                return false;
            }
        }
        return true;
    }
}

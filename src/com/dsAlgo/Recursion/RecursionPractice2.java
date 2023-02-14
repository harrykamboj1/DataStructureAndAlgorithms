package com.dsAlgo.Recursion;

public class RecursionPractice2 {
    public static void main(String[] args) {
        System.out.println(palindrome(1));
        System.out.println(countZeros(0));
        System.out.println(countSteps(123));
        System.out.println(numberOfSteps(14));
        System.out.println(isPalindrome(-121));
    }
//    reverse a number and palindrome
    static int sum;
    static int reverse(int n){
        if(n==0){
            return 0;
        }
        int rem = n%10;
        sum = sum*10 + rem;
        reverse(n/10);
        return sum;
    }
    static boolean palindrome(int n){
       return n==reverse(n);
    }
    public static boolean isPalindrome(int x) {
        if(x<0){return false;}
        return x == reverse1(x);
    }
    public static int reverse1(int x){
        int digits = (int)(Math.log10(x))+1;
        return helper(x, digits);
    }
    public static int helper(int x, int digits){
        if(x%10==x){
            return x;
        }


        int rem = x%10;
        return rem*(int)(Math.pow(10,digits-1))+helper(x/10, digits-1);
    }


//    count zeros
    static int count = 0;
    static int countZeros(int n){
        if (n == 0){
            return 1;
        }
        int rem = n%10;
        if(rem == 0){
            count++;
        }
        countZeros(n/10);
        return count;
    }
//    count steps leetcode 1342
    static int countSteps(int n){
        if(n==0){
            return count;
        }
        if(n%2==0){
            n = n/2;
            count++;
        }
        if(n%2!=0){
            n = n-1;
            count++;
        }
        countSteps(n);
        return count;
    }
//    specially for leetcode 1342
    static int numberOfSteps(int num) {
        return countSteps1(num, 0);
    }
    static int countSteps1(int num, int steps) {
        if(num == 0){
            return steps;
        }
        if(num%2 == 0){
            return countSteps1(num/2, steps + 1);
        }
        return countSteps1(num-1, steps + 1);
    }
}

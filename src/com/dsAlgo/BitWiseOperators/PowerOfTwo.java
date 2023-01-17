package com.dsAlgo.BitWiseOperators;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 16;
        boolean ans = powerOfTwo(n);
        System.out.println(ans);
    }

    static boolean powerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        return (n & n-1) == 0;
    }
}

package com.dsAlgo.BitWiseOperators;

public class NthMagicNumber {
    public static void main(String[] args) {
        int n = 6;
        int ans = 0;
        int base = 5;
        while(n > 0){
// &1 will give the same last binary digit of the n number
            int last = n & 1;
//right shift will remove the last digit of the number
            n =  n>>1;
            ans += last*base;
            base = base*5;
        }
        System.out.println(ans);
    }
}

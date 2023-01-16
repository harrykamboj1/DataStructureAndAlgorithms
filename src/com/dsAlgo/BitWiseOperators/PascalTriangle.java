package com.dsAlgo.BitWiseOperators;

public class PascalTriangle {
    public static void main(String[] args) {
//        int n = 4;
//        int ans = (1 << (n-1));
//        System.out.println(ans);
        int a=0;
        boolean ans1 = powOfTwo(a);
        System.out.println(ans1);
        int n=68;
        System.out.println(isEven(n));
    }
    static boolean isEven(int n){
        return (n&1)!=1;
    }
    static boolean powOfTwo(int a){
        if(a==0){
            return false;
        }
        return  (a & (a-1)) == 0;
    }
}

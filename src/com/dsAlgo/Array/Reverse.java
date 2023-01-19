package com.dsAlgo.Array;

public class Reverse {
    public static void main(String[] args) {
        int x = 1234;
        int ans = reverse(x);
        System.out.println(ans);
    }
    static int reverse(int x){
        long reverse = 0;
        int temp;
         while(x!=0){
             temp = x%10;
             reverse = reverse*10 + temp;
             x = x/10;
         }
        if(reverse >= Integer.MIN_VALUE && reverse <= Integer.MAX_VALUE)
            return (int)reverse;
        else
            return 0;
    }
}

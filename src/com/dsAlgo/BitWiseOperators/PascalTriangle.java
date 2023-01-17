package com.dsAlgo.BitWiseOperators;
// find the sum of nth row in the pascal triangle
public class PascalTriangle {
    public static void main(String[] args) {
        int n = 4;
        int ans = (1 << (n-1));
        System.out.println(ans);
    }
}

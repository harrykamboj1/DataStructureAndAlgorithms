package com.dsAlgo.BitWiseOperators;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 4, 5, 3, 6, 2, 7, 6};
        int ans = singleNumber(arr);
        System.out.println(ans);
        int[] arr1 = {4, 3, 5, 4, 3, 3, 4};
        int ans1 = singleNumberI(arr1);
        System.out.println(ans1);
    }
    //leetcode 136- find the number which occurs once when other appears twice
    static int singleNumber(int[] nums){
        int unique = 0;
        for(int i : nums){
            unique ^= i;
        }
        return unique;
    }
    //leetcode 137- find the number which occurs once when other appears thrice
    static int singleNumberI(int[] nums){
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for(int n : nums) {
                if (((n >> i )& 1) == 1)
                    sum++;
                sum %= 3;
            }
            if (sum != 0){
                res += sum<<i;
            }
        }
        return res;
    }
}

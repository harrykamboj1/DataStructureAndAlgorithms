package com.dsAlgo.SlidingWindowTwoPointer;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }

    public static int longestOnes(int[] nums, int k) {
            int start = 0;
            int end = 0;
            int zeros = 0;
            int count = 0;

            while(end<nums.length){
                if(nums[end] == 0){
                    zeros++;
                }
                end++;
                while (zeros>k){
                    if(nums[start] == 0){
                        zeros--;
                    }
                    start++;
                }
                count = Math.max(count,end-start);
            }
            return count;
    }
}


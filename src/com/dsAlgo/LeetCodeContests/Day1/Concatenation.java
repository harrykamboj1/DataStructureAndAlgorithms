package com.dsAlgo.LeetCodeContests.Day1;

import java.util.*;

public class Concatenation {
    public static void main(String[] args) {
        int[]arr={5,14,13,8,12};
        System.out.println(findTheArrayConcVal(arr));
    }
    public static long findTheArrayConcVal(int[] nums) {
        int i =0;
        int j = nums.length-1;
        long value =0;
        while(i<j){
            String s1 = Integer.toString(nums[i]);
            String s2 = Integer.toString(nums[j]);
            String s = s1+s2;
            int c = Integer.parseInt(s);
            i++;
            --j;
            value = value +c;
        }
        if(i==j){
            value = value + nums[i];
        }
        return value;
    }
}


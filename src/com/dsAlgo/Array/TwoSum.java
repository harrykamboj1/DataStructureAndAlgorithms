package com.dsAlgo.Array;
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr={3,2,3};
        int target = 6;
        int[] ans= twoSum(arr,target);
        System.out.println(Arrays.toString(ans));
    }
    //brute force solution using two pointers
    static int[] twoSum(int[]nums, int target){
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] {i, j};
                    }
                }
            }
        return new int[] {-1,-1};
        }
    }

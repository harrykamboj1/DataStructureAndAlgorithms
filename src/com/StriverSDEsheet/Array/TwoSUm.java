package com.StriverSDEsheet.Array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSUm {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));

    }
    public static int[] twoSum(int[]nums, int target){
        int[] arr = new int[2];
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
            }
            map.put(nums[i], i);
        }
        return arr;
    }
}

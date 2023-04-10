package com.StriverSDEsheet.Array;

import java.util.HashMap;

public class LongestSubsetWithZeroSum {
    public static void main(String[] args) {
        int array[] = {6, -2, 2, -8, 1, 7, 4, -10};
        System.out.println(LongestSubsetWithZeroSum(array, array.length));

    }
    public static int LongestSubsetWithZeroSum(int[] nums, int n) {
        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < n; i++){
            sum +=nums[i];
            if(sum == 0){
                max = i + 1;
            }else{
                if(map.get(sum) != null){
                    max = Math.max(max, i-map.get(sum));
                }else
                    map.put(sum, i);
            }
        }
        return max;
    }
}

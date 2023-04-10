package com.dsAlgo.LeetCodeContests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Weekly340 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distance(new int[]{1, 3, 1, 1, 2})));
    }
    public static long[] distance(int[] nums) {
        long res[] = new long[nums.length];
        int count[] = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int prev = map.get(nums[i]);
                res[i] = res[prev]+count[prev]*(i-prev);
                count[i] = count[prev]+1;
            } else {
                count[i] = 1;
            }

            map.put(nums[i],i);
        }

        count = new int[nums.length];
        map = new HashMap<>();
        long resReverse[] = new long[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            if(map.containsKey(nums[i])){
                int prev = map.get(nums[i]);
                resReverse[i] = resReverse[prev]+count[prev]*(prev-i);
                count[i] = count[prev]+1;
            } else {
                count[i] = 1;
            }
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            res[i] += resReverse[i];
        }
        return res;
    }

}

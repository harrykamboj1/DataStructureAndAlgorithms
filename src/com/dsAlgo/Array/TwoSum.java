package com.dsAlgo.Array;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr={2,7,11,15};
        int target = 9;
        int[] ans= twoSum(arr,target);
        int[] val= twoSum1(arr,target);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(val));
    }
    //brute force solution using two pointers
    static int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1,-1};
    }
     //optimised solution using HashMap
    static int[] twoSum1(int[]nums1, int target){
        int[] array=new int[2];
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(target-nums1[i])){
                array[0]=map.get(target-nums1[i]);
                array[1]=i;
    //here we are returning the array bcoz there is only one solution
//                return array;
            }
            map.put(nums1[i],i);
        }
        return array;
    }
}

package com.dsAlgo.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetProblem {
    public static void main(String[] args) {
          int[] nums = {1,2,2};

        System.out.println(subsetsWithDup(nums));
    }

    // 1. Subset With Duplicate
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outerList = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        makeSubset(nums,0,outerList,innerList);
        return outerList;
    }

    private static void makeSubset(int[] nums, int index, List<List<Integer>> outerList, List<Integer> innerList) {
       outerList.add(innerList);

       for(int i = index;i<nums.length;i++){
           if(i>index && nums[i] == nums[i-1]){
               continue;
           }
           List<Integer> p = new ArrayList<>(innerList);
           p.add(nums[i]);
           makeSubset(nums,i+1,outerList,p);
       }

    }


}

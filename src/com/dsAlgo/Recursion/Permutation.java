package com.dsAlgo.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> dataStructure = new ArrayList<>();
        boolean[] freq  = new boolean[nums.length];

        permutateAnswer(nums,dataStructure,answer,freq);
        return answer;
    }

    private static void permutateAnswer(int[] nums, List<Integer> dataStructure, List<List<Integer>> answer, boolean[] freq) {
          if(dataStructure.size() == nums.length){
              answer.add(new ArrayList<>(dataStructure));
              return;
          }
        for (int i = 0; i < nums.length; i++) {
            if(!freq[i]){
                dataStructure.add(nums[i]);
                freq[i] = true;
                permutateAnswer(nums,dataStructure,answer,freq);
                // After using the given number we delete it from dataStructure array.
                dataStructure.remove(dataStructure.size()-1);
                freq[i] = false;
            }
        }
    }
}

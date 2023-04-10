package com.StriverSDEsheet.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int arr[] = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ls = fourSum(arr, target);
        //System.out.println("raj");
        for(int i = 0;i<ls.size();i++) {
            for(int j = 0;j<ls.get(i).size();j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

        private static List<List<Integer>> fourSum(int[] nums, int target) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            if(nums==null || nums.length == 0){
                return res;
            }
            int n = nums.length;
            Arrays.sort(nums);

            for (int i = 0; i < n; i++) {
                int target3 = target-nums[i];
                for (int j = i+1; j < n; j++) {
                    int target2 = target3-nums[j];

                    int front = j+1;
                    int back = n-1;

                    while (front<back){
                        int twoSum = nums[front] + nums[back];

                        if(twoSum<target2) front++;

                        else if(twoSum > target2)back--;

                        else{
                            List<Integer> quad = new ArrayList<>();
                            quad.add(nums[i]);
                            quad.add(nums[j]);
                            quad.add(nums[front]);
                            quad.add(nums[back]);
                            res.add(quad);

                            // Processing the duplicates of number 3
                            while (front<back && nums[front] == quad.get(2))++front;

                            // Processing the duplicates of number 4
                            while (front<back && nums[back] == quad.get(3)) --back;
                        }
                    }
                    // Processing the duplicates of number 2
                    while(j + 1 < n && nums[j + 1] == nums[j]) ++j;
                }

                // Processing the duplicates of number 1
                while (i + 1 < n && nums[i + 1] == nums[i]) ++i;
            }
            return res;
        }
}

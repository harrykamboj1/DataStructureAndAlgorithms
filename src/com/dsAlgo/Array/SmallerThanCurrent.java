package com.dsAlgo.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class SmallerThanCurrent {
    public static void main(String[] args) {
        int[] arr = {6,5,4,8};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }
//    optimised solution
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int i =0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1 ; i <= 100; i++) {
            count[i] += count[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] - 1];
        }

        return res;
//        brute force

//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if(nums[i]>nums[j]){
//                    count++;
//                }
//            }
//            list.add(count);
//        }
//        int[] arr = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            arr[i] = list.get(i);
//        }
//        return arr;
    }
}

package com.dsAlgo.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2},5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        sum(candidates,target,inner,0,output);
        return output;
    }
    private static void sum(int[] arr, int target, List<Integer> inner, Integer index, List<List<Integer>> output) {


            if(target == 0){
                output.add(new ArrayList<>(inner));
                return;
            }


        for (int i = index; i < arr.length; i++) {
            if(i>index && arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i]>target) break;

            inner.add(arr[i]);
            sum(arr,target-arr[i],inner,i+1,output);
            inner.remove(inner.size() - 1);
        }
    }
}

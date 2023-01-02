package com.dsAlgo.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,7};
        System.out.println(combinationSum(candidates,7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> output = new ArrayList<>();
       List<Integer> inner = new ArrayList<>();
        sum(candidates,target,inner,0,output);
        return output;
    }

    private static void sum(int[] arr, int target,  List<Integer> inner, Integer index, List<List<Integer>> output) {

        if(arr.length == index){
            if(target == 0){
                output.add(new ArrayList<>(inner));
            }
            return;
        }
        if(arr[index] <= target){
            inner.add(arr[index]);
            sum(arr,target-arr[index],inner,index,output);
            inner.remove(inner.size()-1);
        }
        sum(arr,target,inner,index+1,output);
    }
}

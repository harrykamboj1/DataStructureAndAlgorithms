package com.dsAlgo.Recursion;

import java.util.ArrayList;

public class RecursionPractice3 {
    public static void main(String[] args) {
        int[]arr= {1,2,4,8,9,4,13,12};
        System.out.println(isSorted(arr, arr.length));
        System.out.println(sorted(arr,0));
        System.out.println(linearSearch(arr,18));
        System.out.println(linearSearchWithRecursion(arr,12,0));
        ArrayList<Integer> list = new ArrayList<>();
        findAllIndex(arr,4,0, list);
        System.out.println(list);
        System.out.println(findAllIndex2(arr,4,0));
    }
//    array is sorted or not without recursion
    static boolean isSorted(int[]arr, int n) {
        if(n<=1){
            return true;
        }
        for (int i = 1; i < n ; i++) {
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }
//    array sorted or not using recursion
    static boolean sorted(int [] arr, int index){
//  base condition
        if(index == arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] && sorted(arr, index+1);
    }
//    linear search
    static int linearSearch(int[]arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]== target){
                return i;
            }
        }
        return -1;
    }
//  linear search with recursion
    static int linearSearchWithRecursion(int[]arr, int target, int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }else{
            return linearSearchWithRecursion(arr, target, index+1);
        }
    }
//    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> findAllIndex(int[]arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return findAllIndex(arr,target,index+1, list);
    }

    static ArrayList<Integer> findAllIndex2 (int []arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowFunCalls = findAllIndex2(arr,target,index+1);
        list.addAll(ansFromBelowFunCalls);
        return list;
    }
}

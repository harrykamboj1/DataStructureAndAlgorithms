package com.dsAlgo.StackAndQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindowOptimal(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }


    //// Brute Force Solution
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int numOfWindow = n - k + 1;
        int[] result = new int[numOfWindow]; // number of windows

        for (int start = 0; start < numOfWindow; ++start) {
            int end = start + k - 1;
            int maxVal = nums[start];
            for (int i = start + 1; i <= end; ++i) {
                if (nums[i] > maxVal) { // update
                    maxVal = nums[i];
                }
            }
            result[start] = maxVal;
        }

        return result;
    }


    /////// Optimal Solution /////

    //  1. Using Deque
    //  Why Deque => Because in brute force solution we are iterating the same elements of subarray that we have already
    // iterated in the previous subarray and we know that some particular element in that subarray will never be maximum
    // for eg :- In arr = {1, 3, -1, -3, 5, 3, 6, 7}
    // First Subarray is [1,3,-1] and second is [3,-1,-3]
    // and we know that max in first subarray is 3 and max in second will also be 3 and -1,-3 will never be max
    // so that's why Deque is decided to use because it can act as both Stack as well as Queue and we can easily add or delete
    // elements from back as well as from front.

    public static int[] maxSlidingWindowOptimal(int[] nums, int k){

        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] answers = new int[n-k+1];
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        // First visit the first subarray

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast()<nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        arrayList.add(deque.peek());

        for (int i = k; i < n; i++) {
            if(deque.peek() == nums[i-k]){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast()<nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            arrayList.add(deque.peek());
        }
        for (int i = 0; i < answers.length; i++) {
            answers[i] = arrayList.get(i);
        }
    return answers;
    }
}

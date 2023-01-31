package com.dsAlgo.Heap;

import java.util.PriorityQueue;

public class findKthLargestElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int value = findKthLargest(arr, 4);
        System.out.println(value);
    }


    public static int findKthLargest(int[] nums, int k) {
        // (a,b)->b-a is done because pq by default implements minHeap;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}

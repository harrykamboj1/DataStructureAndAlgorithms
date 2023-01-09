package com.dsAlgo.BinarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int [] nums = {0, 2, 3, 1};
        int ans = peakElement(nums);
        System.out.println(ans);
    }
    static int peakElement(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start< end){
            int mid = start + (end - start)/2;
            if (nums[mid]<nums[mid+1]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}

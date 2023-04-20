package com.StriverSDEsheet.Array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        merge(nums1,nums1.length,nums2,nums2.length);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[]nums3 = new int[m+n];
        int k = 0;
        for (int i = 0; i < n ; i++) {
            if(k < nums3.length){
                nums3[k] = nums1[i];
                k++;
            }
        }
        for(int i = 0; i < m; i++){
            if(k < nums3.length){
                nums3[k] = nums2[i];
                k++;
            }
        }
        Arrays.sort(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}

package com.dsAlgo.BinarySearch;

import java.util.Arrays;

public class PeakIndexMountainArray {
    public static void main(String[] args){
        int[]arr={0, 1, 3, 5, 7, 4, 2, 1, 0};
        int ans= peakIndexMountainArray(arr);
        System.out.println((ans));
    }
    static int peakIndexMountainArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
//  you are in descending part of the array
//  this may be the ans, but look at left
//  this is why end!= mid-1
                end = mid;
            }else{
//  you are in ascending part of the array
//  because we know that mid+1 element > mid element
                start = mid + 1;
            }
        }
//  in the end , start == end and pointing to the largest number because of the 2 abpve checks
//  start and end are always trying to find the max element in the above 2 checks
//  hence when they are pointing just one element , that is the max bcoz that is what the checks say
        return start;
    }

}

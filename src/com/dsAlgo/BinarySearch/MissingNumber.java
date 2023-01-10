package com.dsAlgo.BinarySearch;

public class MissingNumber {
    public static void main(String[] args) {
        int[]arr= {9, 6, 7, 8,2,4,3,0,1};
        int ans = missingNumber(arr);
        System.out.println(ans);

    }
    static int missingNumber(int[] nums){
        int n = nums.length;
//        sum of ist n natural numbers
        int totalSum = (n*(n+1))/2;
        for (int i:nums)
        {
//            it will iterate through each element i.e (i) in nums then from the total sum it will minus the element,
//            at last the missing number will left in the total sum so it will return that.
            totalSum-=i;
        }
        return totalSum;
    }
}

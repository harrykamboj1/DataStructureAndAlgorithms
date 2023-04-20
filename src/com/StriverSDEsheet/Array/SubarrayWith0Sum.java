package com.StriverSDEsheet.Array;

import java.util.HashMap;

public class SubarrayWith0Sum {
    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{9, -3, 3, -1, 6, -5}, 6));
    }

    public static int maxLen(int A[], int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxi = 0;
        int sum  = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if(sum==0){
                maxi = i+1;
            }else{
                if(map.get(sum)!=null){
                    maxi = Math.max(maxi,i-map.get(sum));
                }else{
                    map.put(sum,i);
                }
            }
        }
        return maxi;
    }
}
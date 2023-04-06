package com.dsAlgo.LeetCodeContests;

import java.util.*;

public class weekly339 {
    public static void main(String[] args) {
        System.out.println(findMatrix(new int[]{1,3,4,1,2,3,1}));
        System.out.println(findTheLongestBalancedSubstring("01000111"));
    }

    public static int findTheLongestBalancedSubstring(String s) {
        int arr = 0 ;
        char[] chars  = s.toCharArray();
        int n = chars.length;
        for(int i=0;i<n;i++){
            int j = i;
            int count1 = 0 , count2 = 0;
            for(;j<n;j++){
                if(chars[j]=='0'){
                    count1++;
                }
                if(chars[j]=='1'){
                    break;
                }
            }
            int k = j;
            for(;k<n;k++){
                if(chars[k]=='1'){
                    count2++;
                }
                if(chars[k]=='0'){
                    break;
                }
                if(count1==count2){
                    arr = Math.max(arr,(k-i+1));
                }
            }
        }
        return arr;
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> outer   = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        while(map.size() !=0){
            ArrayList < Integer > temp = new ArrayList < > ();
            for(Integer key:map.keySet()){
                if(map.get(key)>0)temp.add(key);
                map.put(key,map.get(key)-1);
            }
            if(temp.size() == 0)break;
            outer.add(new ArrayList<>(temp));
        }
return outer;
    }
}

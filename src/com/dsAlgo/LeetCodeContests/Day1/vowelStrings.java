package com.dsAlgo.LeetCodeContests.Day1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class vowelStrings {
    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
       int[][] queries = {{0,2},{1,4},{1,1}};
//        int[] gifts = {25,64,9,4,100};
//        int k=4;
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }
    public static int[] vowelStrings(String[] words, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();

        String vowels = "aeiou";
         for (int[] arr : queries){
             int left = arr[0];
             int right = arr[1];
             int total = 0;
             for (int i = left; i <= right; i++) {
                char[] val  =  words[i].toCharArray();
                 int count = 0;
                 for (int j = 0; j < val.length; j++) {

                     if(vowels.contains(String.valueOf(val[j]))){
                         count++;
                     }else{
                         count--;
                     }
                 }
                 if(count>=1){
                    total++;
                 }
             }
             result.add(total);
         }
           int[] answer = new int[result.size()];
        for (int i = 0; i < result.size() ; i++) {
              answer[i] = result.get(i);
        }
        return answer;
    }

    public static long pickGifts(int[] arr, int k) {
        ArrayList<Integer> map = new ArrayList<>();
        for(int i : arr){
            map.add(i);
        }

        long sum = 0;
        for (int i = 0; i < k; i++) {
            int max = Collections.max(map);
            int idx = map.indexOf(max);
            int sqr = (int)Math.sqrt(max);
            map.remove(map.get(idx));
            map.add(sqr);
        }

        for (Integer i : map) {
            sum += i;
        }

        return sum;
    }
}

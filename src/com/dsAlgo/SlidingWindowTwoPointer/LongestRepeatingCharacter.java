package com.dsAlgo.SlidingWindowTwoPointer;

import java.util.HashMap;

public class LongestRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
    }

    public static  int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int mostFreq = 0;

        while (right<s.length()){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            mostFreq = Math.max(mostFreq,map.get(arr[right]));

            int canBeReplaced = (right-left+1)-mostFreq;

            if(canBeReplaced>k){
                map.put(arr[left],map.get(arr[left])-1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
    }

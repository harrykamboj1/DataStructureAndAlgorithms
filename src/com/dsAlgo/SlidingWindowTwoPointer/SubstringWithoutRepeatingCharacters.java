package com.dsAlgo.SlidingWindowTwoPointer;

import java.util.*;

public class SubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String str) {
       Map<Character,Integer> map = new HashMap<>();
       int i=0;
       int j=0;
       int max = 0;
       while (j<str.length()){
           map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)+1);
           if(map.size() == j-i+1){
               max = Math.max(max,j-i+1);
               j++;
           }else if(map.size()<j-i+1){
               while (map.size()<j-i+1){
                   map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                   if(map.get(str.charAt(i)) == 0) map.remove(str.charAt(i));
                   i++;
               }
               j++;
           }
       }
       return max;
    }
}

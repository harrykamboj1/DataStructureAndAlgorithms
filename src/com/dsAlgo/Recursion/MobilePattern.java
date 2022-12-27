package com.dsAlgo.Recursion;

import java.util.ArrayList;
import java.util.List;

public class MobilePattern {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static void  pattern(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        int digit = unprocessed.charAt(0)-'0'; //this will convert '2' to 2

        for (int i = (digit-1)*3; i < digit * 3; i++) {
           char p = (char)('a'+ i);
             pattern(p+processed ,unprocessed.substring(1));
        }
        
    }


    public static List<String> letterCombinations(String digits) {
        String[] lookup = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> results = new ArrayList<>();
        generate("", digits, lookup, 0, results);
        return results;
    }

    private static String generate(String prefix, String digits, String[] lookup, int index, List<String> collector) {
        if (index == digits.length()) return prefix;

        int digit = Character.getNumericValue(digits.charAt(index));
        String chars = lookup[digit];
        index++;

        for(int i = 0; i < chars.length(); i++) {
            String result = generate(prefix+chars.charAt(i), digits, lookup, index, collector);
            if (result != null) collector.add(result);
        }

        return null;
    }
}

package com.StriverSDEsheet.Array;

import java.util.HashMap;

public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
    static HashMap<String, Integer> map = new HashMap<>();
    public static int uniquePaths(int m, int n){
//        base condition
        if(m == 1 || n == 1){
            return 1;
        }
//        creating a map to avoid repeative recursive calls
        String cell = new String(m +","+ n);
        if(map.containsKey(cell))
            return map.get(cell);
//        here doing opposite in down calculating up path and in right there is left one
//        bcoz there is no grid.

        int down = uniquePaths(m-1, n);
        int right = uniquePaths(m, n-1);

        map.put(cell, down+right);
        return down + right;
    }
}

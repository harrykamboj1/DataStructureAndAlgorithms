package com.StriverSDEsheet.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> row, col=null;
        for (int i = 0; i < numRows; ++i) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                // if Row is equal to first and last then add simply 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // add the value of the above row
                    row.add(col.get(j - 1) + col.get(j));
                }
            }
                col = row;
                result.add(row);
        }
        return result;
    }
}

package com.StriverSDEsheet.Array;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][]arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Original Array is- "+ Arrays.deepToString(arr));
        rotate(arr);
        System.out.println("Rotated Image of Array is- "+Arrays.deepToString(arr));
    }

    static void rotate(int[][] matrix) {
//        transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
//      swap
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length/2; j++ ) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j]= matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]= temp;
            }
        }
    }
}

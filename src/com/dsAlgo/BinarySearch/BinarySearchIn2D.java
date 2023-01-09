package com.dsAlgo.BinarySearch;

import java.util.Arrays;

public class BinarySearchIn2D {
    public static void main(String[] args) {
//        int [][] arr= {{10, 20,30,40},
//                {11, 25, 35, 45},
//                {28, 29, 37, 49},
//                {33, 34, 38, 50},
//        };
        int [][] arr ={{-1, 3}};
        System.out.println(searchMatrix(arr, 3));
    }
     static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while(row < matrix.length && column>= 0){
            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column] < target){
                row++;
            }else{
                column--;
            }
        }
        return false;
    }
//    returning index

//    static int[] search(int[][] matrix, int target){
//        int row = 0;
//        int column = matrix.length - 1;
//        while(row < matrix.length && column >= 0){
//            if(matrix[row][column] == target){
//                return new int[] {row,column};
//            }else if(matrix[row][column] > target){
//                column--;
//            }else{
//                row++;
//            }
//        }
//        return new int[]{-1, -1};
//    }
}

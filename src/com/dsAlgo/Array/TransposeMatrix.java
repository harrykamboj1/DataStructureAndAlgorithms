package com.dsAlgo.Array;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}};
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }

    static int[][] transpose(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int[][] B = new int[N][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                //transpose
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}

package com.dsAlgo.BitWiseOperators;

public class FlipImage {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0},
        };
        int[][] ans = flipAndInvertImage(arr);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
//we are taking the entire row at once
    static int[][] flipAndInvertImage(int[][] image) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }

        for (int[] row : image) {
            int start = 0;
            int end = row.length - 1;
            while (start <= end) {
                if (row[start] == row[end]) {
//inverting the image simultaneously
                    row[start] ^= 1;
//swapping the row
                    row[end] = row[start];
                }
                start++;
                end--;
            }
        }
        return image;
    }
//kunal kushwaha solution
    private static int[][] flipImage(int[][] image) {
        //we are taking the entire row at once
        for (int[] row : image) {
//            reverse the array
//here we are dividing it by 2 bcoz we are reversing using half row
            for (int i = 0; i < (image[0].length + 1) / 2; i++) {
//swapping
                int temp = row[i] ^ 1;
//subracting i bcoz from starting it is increasing and from another end it is descreasing
                row[i] = row[image[0].length - i - 1] ^ 1;
                row[image[0].length - i - 1] = temp;
            }
        }
        return image;
    }
}
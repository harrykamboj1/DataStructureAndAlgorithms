package com.dsAlgo.LeetCodeContests.Day2;

import java.util.ArrayList;
import java.util.List;

public class weekly340 {
    public static void main(String[] args) {


    }
    public static int diagonalPrime(int[][] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        int mainDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums.length ; j++) {
                if(i == j){
                    mainDiagonal = nums[i][j];
                    if(isPrime(mainDiagonal)){
                        list.add(mainDiagonal);
                    }
                }
                if(i == nums.length -j - 1){
                    secondaryDiagonal = nums[i][j];
                    if(isPrime(secondaryDiagonal)){
                        list.add(secondaryDiagonal);
                    }
                }
            }
            for(int k = 0; k < list.size(); k++){
                max = Math.max(max, list.get(k));
            }


        }
        return max;
    }
    public static boolean isPrime (int n){
        if(n <= 1){
            return false;
        }
        int c = 2;
        while (c*c <= n){
            if (n%c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
}

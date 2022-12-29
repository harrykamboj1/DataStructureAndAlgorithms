package com.dsAlgo.Recursion;

import java.util.Arrays;

public class BackTracking {
    public static void main(String[] args) {
        boolean[][] board = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path = new int[board.length][board[0].length];
        backTrackingPrint("",board,0,0,path,1);
    }

    private static void backTrackingPrint(String p, boolean[][] maze, int row, int col, int[][] path, int step) {
        if(row == maze.length-1 && col == maze[0].length-1){
            for(int[] arr :path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        //To check condition whether any path is blocked or not
        if(!maze[row][col]){
            return;
        }


        // while going for recursive calls mark the path as false as they are already visited
        maze[row][col] = false;
        path[row][col] = step;

        if(row<maze.length-1){
            backTrackingPrint(p+"D",maze,row+1,col,path,step+1);
        }

        if(col<maze[0].length-1){
            backTrackingPrint(p+"R",maze,row,col+1,path,step+1);
        }

        if(row>0){
            backTrackingPrint(p+"U",maze,row-1,col,path,step+1);
        }
        if(col>0){
            backTrackingPrint(p+"L",maze,row,col-1,path,step+1);
        }

        //this is the line where fxn will over
        //so before fxn gets removed ,also remove the changes that were made by fxn
        //that is making path not visited again
        maze[row][col] = true;
        path[row][col] = 0;
    }


    private static void backTracking(String p, boolean[][] maze, int row, int col) {

        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(p);
            return;
        }

        //To check condition whether any path is blocked or not
        if(!maze[row][col]){
         return;
        }


        // while going for recursive calls mark the path as false as they are already visited
        maze[row][col] = false;

        if(row<maze.length-1){
            backTracking(p+"D",maze,row+1,col);
        }

        if(col<maze[0].length-1){
            backTracking(p+"R",maze,row,col+1);
        }

        if(row>0){
            backTracking(p+"U",maze,row-1,col);
        }
        if(col>0){
            backTracking(p+"L",maze,row,col-1);
        }

         //this is the line where fxn will over
        //so before fxn gets removed ,also remove the changes that were made by fxn
        //that is making path not visited again
        maze[row][col] = true;
    }
}

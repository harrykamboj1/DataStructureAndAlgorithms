package com.dsAlgo.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class NoOfIslands {
    public static void main(String[] args) {
        System.out.println(countDistinctIslands(new int[][]{{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}}));
    }
    public static int countDistinctIslands(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] vis = new int[n][m];
            HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,vis,grid,list,i,j);
                    set.add(list);
                }
            }

        }
        return set.size();
    }

    private static void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> list, int row1, int col1) {
       vis[row][col] = 1;
        list.add(toString(row - row1, col - col1));
        int n = grid.length;
        int m  = grid[0].length;


        int[] delrow = {-1,0,+1,0};
        int[] delcol = {0,-1,0,+1};

        for (int i = 0; i < 4; i++) {

            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow,ncol,vis,grid,list,row1,col1);
            }
        }
    }

    class Pair{
        int first;
        int second;

        public Pair(int first,int second){
            this.first = first;
            this.second= second;
        }
    }
    private static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}

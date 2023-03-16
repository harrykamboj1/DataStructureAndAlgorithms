package com.dsAlgo.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMaze {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        int val = shortestPathBinaryMatrix(grid);
        System.out.println(val);
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;

        // condition to check if starting and ending point are not equal to one
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }

        // All 8 directions
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        // We create this 2d grid in order to store the visited Path;
        boolean[][] vist = new boolean[row][col];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});

        vist[0][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] curPos = q.poll();


                if (curPos[0] == row - 1 && curPos[1] == col - 1) {
                    return ans;
                }

                for (int[] di : dir) {
                    int nextX = curPos[0] + di[0];
                    int nextY = curPos[1] + di[1];

                    if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col || vist[nextX][nextY] || grid[nextX][nextY] == 1) {
                        continue;
                    }

                    vist[nextX][nextY] = true;
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }
        return -1;
    }
}

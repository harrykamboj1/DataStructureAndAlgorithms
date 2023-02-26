package com.dsAlgo.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottanOranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
    // Store The Position Of Rottan Oranges
    static class Position{
        int x;
        int y;
        Position(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public  static  int orangesRotting(int[][] grid){
        Queue<Position> queue = new LinkedList<>();
        int total = 0 , rotton = 0,time = 0;

        // traverse the grid, offer position of rotten orange into queue, and count the total num of orange
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1 || grid[i][j]==2)total++;
                if(grid[i][j] == 2)queue.offer(new Position(i,j));
            }
        }
        // if there is no orange, return 0;
        if(total == 0)return 0;

        while (!queue.isEmpty()){
            // size is the num of rotten oranges of the last round
            int size = queue.size();

            rotton += size;
            if(rotton == total)return time;

            time++;

            // Continue to dequeue until all rotten oranges of last round are removed from the queue
            for (int i = 0; i < size; i++) {
                Position p = queue.peek();
                // check the cell in the left/right/top/down of the rotten orange, if it is a fresh orange, enqueue it.
                if(p.x + 1< grid.length && grid[p.x+1][p.y]==1){
                    grid[p.x + 1][p.y] = 2;
                    queue.offer(new Position(p.x + 1, p.y));
                }
                if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    queue.offer(new Position(p.x - 1, p.y));
                }
                if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1) {
                    grid[p.x][p.y + 1] = 2;
                    queue.offer(new Position(p.x, p.y + 1));
                }
                if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
                    grid[p.x][p.y - 1] = 2;
                    queue.offer(new Position(p.x, p.y - 1));
                }
                queue.poll();
            }
        }
        return -1;
    }
}

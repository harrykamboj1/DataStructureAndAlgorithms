package com.dsAlgo.Graph;

import java.util.PriorityQueue;

public class MinimalEffort {
    public static void main(String[] args) throws Exception {
        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};


        int ans = MinimumEffort(heights);

        System.out.print(ans);
        System.out.println();
    }

    static class Pair{
        int row;
        int col;
        int dist;
        public Pair(int dist,int row,int col){
            this.col = col;
            this.row = row;
            this.dist = dist;
        }
    }

    private static int MinimumEffort(int[][] heights) throws Exception{
            PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.dist - y.dist);

                int n = heights.length;
                int m = heights[0].length;

                int[][] dist = new int[n][m];
                for (int i = 0; i < dist.length; i++) {
                    for (int j = 0; j < dist[0].length; j++) {
                        dist[i][j] = (int)(1e9);
                    }
                }
                dist[0][0] = 0;
                pq.add(new Pair(0,0,0));


                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, 1, 0, -1};


                while (!pq.isEmpty()){
                    Pair it = pq.peek();
                    int diff = it.dist;
                    int row = it.row;
                    int col = it.col;
                    pq.remove();

                    if(row == n-1 && col == m-1)return diff;


                    for(int i=0;i<4;i++){
                        int newR = row + dr[i];
                        int newC = col + dc[i];

                        if(newR>=0 && newC>=0 && newR < n && newC < m){
                            // Effort can be calculated as the max value of differences
                            // between the heights of the node and its adjacent nodes.
                            int newEffort = Math.max(Math.abs(heights[row][col]-heights[newR][newC]),diff);

                            if(newEffort< dist[newR][newC]){
                                dist[newR][newC]  =newEffort;
                                pq.add(new Pair(newEffort,newR,newC));
                            }
                        }
                    }
                }
            return 0;
    }

}

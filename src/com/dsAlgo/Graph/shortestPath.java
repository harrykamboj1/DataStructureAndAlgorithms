package com.dsAlgo.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class shortestPath {
    public static void main(String[] args) {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};


        int res[] = findShortestPath(edge,n,m,0);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    private static int[] findShortestPath(int[][] edge, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjList.get(edge[i][0]).add(edge[i][1]);
            adjList.get(edge[i][1]).add(edge[i][0]);
        }

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i]= (int)1e9;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        dist[src] = 0;
        while (!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();

            for (int it:adjList.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it] = dist[node]+1;
                    queue.add(it);
                }
            }
        }
        // Updated shortest distances are stored in the resultant array ‘ans’.
        // Unreachable nodes are marked as -1.
        for(int i = 0;i<n;i++) {
            if(dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}

package com.dsAlgo.Graph;


// 1. BellManFordAlgorithm help you to detect negative cycles as well
// 2. Applicable for Directed Graph

import java.util.ArrayList;
import java.util.Arrays;

/*   Q1. Why N-1 Iterations ?
     A1. Since in a graph of N nodes , in worse case you will take N-1 edges to reach from the first to the last , thereby we iterate for N-1 iterations.
     Q2. How to detect Negative Cycles ?
     A2. We know if we keep on rotating inside a negative cycle, the path weight will be decreased in every iteration. But according to our intuition, we should have minimized all the distances within N-1 iterations(that means, after N-1 iterations no relaxation of edges is possible).
* */
public class BellManFordAlgorithm {
    public static void main(String[] args) {
        int V = 4;
        int S = 2;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 0, 3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -1)));
                add(new ArrayList<Integer>(Arrays.asList(2, 0, 1)));
            }
        };



        int[] dist = bellman_ford(V, edges, S);
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");
    }
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int)1e8;
        }

        dist[S]= 0;

        for (int i = 0; i < V - 1; i++) {
            for(ArrayList<Integer> it : edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for(ArrayList<Integer> it : edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }

}

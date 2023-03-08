package com.dsAlgo.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckForCycleInDirectedUsingBFS {
    // Kahn's Algorithm
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
   /*
   * Note: Points to remember when a node is popped out,
   *  indegrees for all its adjacent nodes are decreased by one and if any of them becomes 0,
   *  we push that node into the queue.
   *  Meanwhile, we include the current node in the answer immediately after it is popped out of the queue.
   * */
    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for(int it:adj.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        int[] topo = new int[V];
        int i=0;
        while (!queue.isEmpty()){
            int node = queue.peek();
            queue.poll();
            topo[i++]  = node;

            for (int it:adj.get(node)){
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
        return topo;
    }

}

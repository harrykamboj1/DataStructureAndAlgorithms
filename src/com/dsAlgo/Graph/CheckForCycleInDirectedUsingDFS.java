package com.dsAlgo.Graph;

import java.util.ArrayList;

public class CheckForCycleInDirectedUsingDFS {
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);


        boolean ans = isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }
    // Function to detect cycle in a directed graph.
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>>adj){
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if(vis[i]==0){
                if(dfsCheck(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }

    private static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;

        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfsCheck(it, adj, vis, pathVis))return true;
            }else if(pathVis[it]==1)return true;
        }
        pathVis[node] = 0;
        return false;
    }
}
/*
* The algorithm steps are as follows:

 We will traverse the graph component-wise using the DFS technique.
 Make sure to carry two visited arrays in the DFS call.
 *  One is a visited array(vis) and the other is a path-visited(pathVis) array.
 *  The visited array keeps a track of visited nodes, and the path-visited keeps a track of visited nodes in the current traversal only.
 While making a DFS call, at first we will mark the node as visited in both the arrays and then will traverse through its adjacent nodes.
 *  Now, there may be either of the three cases:
     Case 1: If the adjacent node is not visited, we will make a new DFS call recursively with that particular node.
     Case 2: If the adjacent node is visited and also on the same path(i.e marked visited in the pathVis array), we will return true, because it means it has a cycle, thereby the pathVis was true.
     * Returning true will mean the end of the function call, as once we have got a cycle, there is no need to check for further adjacent nodes.
     Case 3: If the adjacent node is visited but not on the same path(i.e not marked in the pathVis array), we will continue to the next adjacent node,
     * as it would have been marked as visited in some other path, and not on the current one.
    Finally, if there are no further nodes to visit,
    * xwe will unmark the current node in the pathVis array and just return false. Then we will backtrack to the previous node with the returned value. The point to remember is, while we enter we mark both the pathVis and vis as true, but at the end of traversal to all adjacent nodes, we just make sure we unmark the pathVis and still keep the vis marked as true, as it will avoid future extra traversal calls. */
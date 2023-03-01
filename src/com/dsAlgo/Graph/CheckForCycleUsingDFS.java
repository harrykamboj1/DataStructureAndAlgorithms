package com.dsAlgo.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckForCycleUsingDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1);

        CheckForCycleUsingDFS obj = new CheckForCycleUsingDFS();
        boolean ans = obj.isCycle(5, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       try{
           boolean[] visited = new boolean[V];
           Arrays.fill(visited,false);
           for (int i = 0; i < V; i++) {
               if(!visited[i]){
                   if(dfs(i, -1, visited, adj)){
                    return true;
                   }
               }
           }
       }catch (Exception exception){
           System.out.println((exception.getMessage()));
       }
       return false;
    }

    private boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for(int adjNode : adj.get(node)){
            if(!visited[adjNode]){
                if(dfs(adjNode, node, visited, adj))return true;
            }else if(adjNode!=parent)return true;
        }
        return false;
    }

    static class Node{
        int first;
        int second;
        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


}

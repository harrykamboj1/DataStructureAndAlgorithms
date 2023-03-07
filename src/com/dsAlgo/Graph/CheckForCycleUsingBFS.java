package com.dsAlgo.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckForCycleUsingBFS {

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

        CheckForCycleUsingBFS obj = new CheckForCycleUsingBFS();
        boolean ans = obj.isCycle(5, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    static class Node{
        int first;
        int second;
        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public boolean isCycle(int V , ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        for(int i=0;i<V;i++)
            if(!visited[i])
                if(checkForCycle(adj, i,visited))
                    return true;

        return false;
    }

    private boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(node,-1));
        visited[node] = true;

        while (!q.isEmpty()){
            int node1 = q.peek().first;
            int par = q.peek().second;
            q.remove();

            for (Integer it : adj.get(node1)){
                if(!visited[it]){
                    q.add(new Node(it,node1));
                    visited[it] = true;
                }// if adjacent node is visited and is not its own parent node
                //The parent will be needed so that we don’t do a backward traversal in the graph, we just move frontwards.
                else if(par != it) return true;
            }
        }
        return false;
    }


}

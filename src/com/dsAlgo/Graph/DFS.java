package com.dsAlgo.Graph;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList < Integer > ans = dfsGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
    public static ArrayList<Integer> dfsGraph(int V , ArrayList<ArrayList<Integer>> adList){
        //boolean Array to keep track of visited arrays
        boolean[] visited = new boolean[V+1];
        visited[0] = true;
        ArrayList<Integer> ls  = new ArrayList<>();
        dfs(0,visited,adList,ls);
        return ls;
    }

    private static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adList, ArrayList<Integer> ls) {
         visited[node] = true;
         ls.add(node);

         for (Integer it : adList.get(node)){
             if(!visited[it]){
              dfs(it,visited,adList,ls);
             }
        }
    }

}

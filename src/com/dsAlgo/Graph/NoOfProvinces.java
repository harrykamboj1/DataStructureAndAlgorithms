package com.dsAlgo.Graph;

public class NoOfProvinces {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
    public static int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n+1];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,M,visited);
            }
        }
        return count;
    }
    public static void dfs(int Node,int[][] M,boolean[] visited){
        for(int j=0;j<M[Node].length;j++){
            if(!visited[j]&& M[Node][j]!=0){
                visited[j] = true;
                dfs(j,M,visited);
            }
        }
    }
}

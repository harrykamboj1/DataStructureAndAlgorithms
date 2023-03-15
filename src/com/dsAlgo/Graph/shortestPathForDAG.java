package com.dsAlgo.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class shortestPathForDAG {
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};

        int res[] = shortestPathDAG(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static int[] shortestPathDAG(int N, int M, int[][] edge) {
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                ArrayList<Pair> temp = new ArrayList<>();
                adj.add(temp);
            }
            //We create a graph first in the form of an adjacency list.
            for (int i = 0; i < M; i++) {
                int u = edge[i][0];
                int v = edge[i][1];
                int w = edge[i][2];
                adj.get(u).add(new Pair(v, w));
            }
            int[] vis = new int[N];
            //Now, we perform topo sort using DFS technique
            //and store the result in the stack st.

            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < N; i++) {
                if (vis[i] == 0) {
                    topoSort(i, st, adj, vis);
                }
            }

            //Further, we declare a vector ‘dist’ in which we update the value of the nodes’
            //distance from the source vertex after relaxation of a particular node.
            int[] dist = new int[N];

            for (int i = 0; i < N; i++) {
                dist[i] = (int) 1e9;
            }
            dist[0] = 0;

            while (!st.isEmpty()) {
                int node = st.peek();
                st.pop();

                for (int i = 0; i < adj.get(node).size(); i++) {
                    int v = adj.get(node).get(i).first;
                    int w = adj.get(node).get(i).second;
                    if (dist[node] + w < dist[v]) {
                        dist[v] = w + dist[node];
                    }
                }

            }
            for (int i = 0; i < N; i++) {
                if (dist[i] == 1e9) dist[i] = -1;
            }
            return dist;
        }

        private static void topoSort(int node, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj, int[] vis) {
            vis[node] = 1;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int j = adj.get(node).get(i).first;
                if (vis[j] == 0) {
                    topoSort(j, st, adj, vis);
                }
            }
            st.add(node);
        }
}

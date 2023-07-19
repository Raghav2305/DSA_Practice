package com.company;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Path {
    public boolean validPath(int n, int[][] edges, int source, int destination){
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges
             ) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] visited = new int[n+1];

        for (int i = 0; i < n; i++) {
            if(visited[i] == 0){
                BFS(adj, i, visited);
                if(visited[source] == 1 && visited[destination] == 0 ||
                visited[source] == 0 && visited[destination] ==1){
                    return false;
                }
            }
        }
        return true;
    }
    public void BFS(List<List<Integer>> adj, int src, int[] visited){
        visited[src] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (q.size()>0){
            int ele = q.remove();
            for (Integer it: adj.get(ele)
                 ) {
                if (visited[it] == 0){
                    visited[it] =1;
                    q.add(it);
                }
            }
        }
    }

    public static void main(String[] args) {
        Path obj = new Path();
        int n = 3;
        int[][] edges = {{0,1}, {1,2}, {2,0}};
        int source = 0;
        int destination = 2;
        System.out.println(obj.validPath(n, edges, source, destination));
    }
}



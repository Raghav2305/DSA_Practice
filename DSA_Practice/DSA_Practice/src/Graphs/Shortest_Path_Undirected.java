package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_Undirected {
     public static int[] shortestPath(int[][] edges,int n,int m ,int src){
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

         for (int i = 0; i < n; i++) {
             adj.add(new ArrayList<Integer>());
         }

         for (int i = 0; i < m; i++) {
             adj.get(edges[i][0]).add(edges[i][1]);
             adj.get(edges[i][1]).add(edges[i][0]);
         }

         int[] dist = new int[n];
         Arrays.fill(dist, (int) (1e9));
         dist[src] = 0;

         Queue<Integer> q = new LinkedList<>();
         q.add(src);

         while(!q.isEmpty()){
             int node = q.peek();
             q.poll();

             for(int num : adj.get(node)){
                 if(dist[node] + 1 < dist[num]){
                     dist[num] = dist[node] + 1;
                     q.add(num);
                 }
             }
         }

         for (int i = 0; i < n; i++) {
             if(dist[i] == 1e9){
                 dist[i] = -1;
             }
         }
         return dist;
     }
}

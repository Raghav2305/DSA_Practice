package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford_Algorithm {
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int dist [] = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;

        for (int i = 0; i < V; i++) {
            for (ArrayList<Integer> iterator : edges){
                int u = iterator.get(0);
                int v = iterator.get(1);
                int wt = iterator.get(2);

                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }


        for (ArrayList<Integer> iterator : edges){
            int u = iterator.get(0);
            int v = iterator.get(1);
            int wt = iterator.get(2);
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                int[]temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }
}

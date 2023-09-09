package Graphs;

import java.util.ArrayList;

public class Detect_Cycle_in_Directed_Graph {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;

        for (int num : adj.get(node)){
            if(vis[num] == 0){
                if(dfs(num, adj, vis, pathVis)){
                    return true;
                }
            }
            else if (pathVis[num] == 1){
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }

    public boolean detect_cycle(int V, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if(vis[i] == 0){
                if(dfs(i, adj, vis, pathVis)){
                    return true;
                }
            }
        }
        return false;
    }
}

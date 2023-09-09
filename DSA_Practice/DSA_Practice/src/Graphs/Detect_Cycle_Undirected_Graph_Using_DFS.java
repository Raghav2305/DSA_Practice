package Graphs;

import java.util.ArrayList;

public class Detect_Cycle_Undirected_Graph_Using_DFS {
    public static boolean detect_cycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                if(dfs(i, -1, vis, adj)){
                    return true;
                };
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;

        for(int num : adj.get(node)){
            if(!vis[num]){
                if(dfs(num, node, vis, adj)){
                    return true;
                }
            }
            else if(num != parent){
                return true;
            }
        }
        return false;
    }


}

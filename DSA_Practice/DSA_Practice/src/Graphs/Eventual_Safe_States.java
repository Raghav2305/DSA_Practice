package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class Eventual_Safe_States {
    public List<Integer> eventualSafeNodes(int[][] graph){
        int n = graph.length;

        List<List<Integer>> adjListArray = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjListArray.add(new ArrayList<Integer>());
        }

        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                adjListArray.get(u).add(v);
            }
        }

        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[]check = new int[n];

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(vis[i] == 0){
                dfsCheck(i, vis, pathVis, check, adjListArray);
            }
        }

        for (int i = 0; i < n; i++) {
            if(check[i] == 1){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean dfsCheck(int node, int[] vis, int[] pathVis, int[] check, List<List<Integer>> adj){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for (int num : adj.get(node)){
            if(vis[node] == 0){
                if(dfsCheck(num, vis, pathVis, check, adj)){
                    return true;
                }
            }
            else if (pathVis[node] == 1){
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}

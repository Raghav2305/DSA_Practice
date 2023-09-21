package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort_DFS {
    private static void dfs(int node, int[] vis, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        for (int num : adj.get(node)){
            if(vis[num] == 0){
                dfs(num, vis, stack, adj);
            }
        }
        stack.push(node);
    }

    public static int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if(vis[i] == 0){
                dfs(i, vis, stack, adj);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while(!stack.isEmpty()){
            ans[i] = stack.peek();
            i++;
            stack.pop();
        }

        return ans;

    }
}

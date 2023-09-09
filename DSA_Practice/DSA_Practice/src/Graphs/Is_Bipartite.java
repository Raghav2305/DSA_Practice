package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Is_Bipartite {
    public boolean isBipartite(int[][] graph) {

        int l = graph[0].length;
        ArrayList<ArrayList<Integer>> adjListArray
                = new ArrayList<ArrayList<Integer>>(l);


        for (int i = 0; i < l; i++) {
            adjListArray.add(new ArrayList<Integer>());
        }

        int i, j;
        for (i = 0; i < graph[0].length; i++) {
            for (j = 0; j < graph.length; j++) {
                if (graph[i][j] != 0) {
                    adjListArray.get(i).add(j);
                }
            }
        }

        int[] color = new int[adjListArray.size()];

        Arrays.fill(color, -1);

        for (int k = 0; k < color.length; k++) {
            if(color[k] == -1){
                if(!dfs(k, 0, color, adjListArray)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj){
        color[node] = col;

        for (int num : adj.get(node)){
            if(color[num] == -1){
                if(!dfs(num, 1 - col, color, adj)){
                    return false;
                }
            }else if (color[num] == col){
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int k, int[] color, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        color[k] = 0;

        while (!queue.isEmpty()){
            int num = queue.peek();
            queue.poll();

            for(int neighbour : adj.get(num)){
                if(color[neighbour] == -1){
                    color[neighbour] = 1 - color[num];
                    queue.add(neighbour);
                }else if(color[neighbour] == color[num]){
                    return false;
                }
            }
        }
        return true;
    }
}

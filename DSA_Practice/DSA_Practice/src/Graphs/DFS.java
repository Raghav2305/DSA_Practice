package Graphs;

import java.util.ArrayList;

public class DFS {
    public static ArrayList<Integer> dfsTraversal(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> dfs_ans = new ArrayList<>();

        boolean vis[] = new boolean[V];
        vis[1] = true;
        dfs(1, vis, adj, dfs_ans);
        return dfs_ans;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsAns) {
        vis[node] = true;
        dfsAns.add(node);

        // This for loop runs for every neighbour of a node. Since they depend upon the degree of the node, therefore, the entire number of neighbours boil down to the summation of the degrees of all nodes. TC turns out to be O(2E) where (E -> edges).

        for(int num : adj.get(node)){
            if(!vis[num]){

                // This recursive function is called for every node and hence takes up a time of O(N) where (N -> number of nodes of the graph).

                dfs(num, vis, adj, dfsAns);

            }
        }
    }

    // Time Complexity --> O(N) + O(2E) : for undirected graph
    // Time Complexity --> O(N) + O(E) : for directed graph
    // Space Complexity --> O(N) + O(N) + O(N) ~ O(N)

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<>();
        for(int i=0; i<=7; i++){
            adjacency.add(new ArrayList<Integer>());
        }

        adjacency.get(1).add(2);
        adjacency.get(1).add(3);

        adjacency.get(2).add(1);
        adjacency.get(2).add(4);
        adjacency.get(2).add(5);

        adjacency.get(3).add(1);
        adjacency.get(3).add(6);
        adjacency.get(3).add(7);


        adjacency.get(4).add(2);
        adjacency.get(5).add(2);
        adjacency.get(6).add(3);
        adjacency.get(7).add(3);

        System.out.println(adjacency);


        ArrayList<Integer> ans = dfsTraversal(8, adjacency);

        for(int num : ans){
            System.out.print(num + " --> ");
        }
        System.out.println("End");
    }
}

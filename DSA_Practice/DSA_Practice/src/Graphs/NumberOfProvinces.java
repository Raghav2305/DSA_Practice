package Graphs;

//Note - When working with adjacency matrices, for calling traversal, an extra check is needed along with the visited array. The node should not be visited in the visited array as well as an edge should be present between the nodes you are working with. This is the extra check : "vis[num] == 0 && adj[node][num] == 1". It is required since there is no explicit mention in the matrix format regarding what nodes are connected.

public class NumberOfProvinces {
    private static void dfs(int node, int[] vis, int[][] adj) {

        vis[node] = 1;
        for (int num = 0; num < adj.length; num++) {
            if (vis[num] == 0 && adj[node][num] == 1) {
                dfs(num, vis, adj);
            }
        }

    }

    public static int findCircleNum(int[][] isConnected) {
        int numOfProvinces = 0;
        int vis[] = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if(vis[i] == 0){
                numOfProvinces++;
                dfs(i, vis, isConnected);
            }
        }
        return numOfProvinces;
    }

    // Time Complexity --> O(N) + O(V + 2E)
    // Space Complexity --> O(N) + O(N) ~ O(N)

    public static void main(String[] args) {
        int [][] check = {{1,0,0}, {0,1,0}, {0,0,1}};
        int ans = findCircleNum(check);
        System.out.println(ans);
    }
}


package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static ArrayList<Integer> bfsTraversal(int V, ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];

        q.add(1);
        vis[1] = true;

        // The while loop will run for all nodes as it will consider all nodes in the queue. So it accounts for O(N).

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            // This for loop will run for all neighbours i.e. all nodes at an equivalent distance which is the degree of the node. So for the entire graph, the number of degrees are calculated as 2 * E (where E --> number of edges). So it accounts for O(2E).

            for(int num : adj.get(node)){
                if(!vis[num]){
                    vis[num] = true;
                    q.add(num);
                }
            }
        }
        return bfs;
    }

    // Total Time Complexity - O(N) + O(2E)
    // Total Space Complexity - O(3N) ---> O(N)

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


        ArrayList<Integer> ans = bfsTraversal(8, adjacency);

        for(int num : ans){
            System.out.print(num + " --> ");
        }
        System.out.println("End");
     }
}

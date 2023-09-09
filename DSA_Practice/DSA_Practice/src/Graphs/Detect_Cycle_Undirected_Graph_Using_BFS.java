package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detect_Cycle_Undirected_Graph_Using_BFS {
    public  boolean check(int i, int V, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[i] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, -1));

        while(!queue.isEmpty()){
            int curr = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();

            for (int num : adj.get(curr)){
                if(!vis[num]){
                    vis[num] = true;
                    queue.add(new Pair(num, curr));
                }
                else if(parent != num){
                    return true;
                }
            }
        }
        return false;
    }
    public  boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                if(check(i, V, vis, adj)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        Detect_Cycle_Undirected_Graph_Using_BFS obj = new Detect_Cycle_Undirected_Graph_Using_BFS();
        boolean ans = obj.detectCycle(4, adj);
        if (ans)
            System.out.println("Cycle");
        else
            System.out.println("No Cycle");
    }

}

package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_Sort_BFS_Kahns_Algo {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for(int num : adj.get(i)){
                inDegree[num] ++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int[] topo = new int[V];
        int i = 0;
        while (!queue.isEmpty()){
            int element = queue.peek();
            queue.poll();

            topo[i++] = element;

            for(int num : adj.get(element)){
                inDegree[num] --;
                if(inDegree[num] == 0){
                    queue.add(num);
                }
            }
        }
        return topo;
    }
}

package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detect_Cycle_DAG_KahnsAlgo {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
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
        int count = 0;
        int i = 0;
        while (!queue.isEmpty()){
            int element = queue.peek();
            queue.poll();

            count ++;

            for(int num : adj.get(element)){
                inDegree[num] --;
                if(inDegree[num] == 0){
                    queue.add(num);
                }
            }
        }

        return count != V;

    }
}

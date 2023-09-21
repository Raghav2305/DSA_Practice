package Graphs;

import java.util.*;

public class Eventual_Safe_Nodes_Using_TOPO {
    public List<Integer> eventualSafeNodes(int[][] graph) {

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

        int[] inDegree = new int[n];

        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i=0; i<n; i++){
            adjRev.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for(int num : adjListArray.get(i)){
                adjRev.get(num).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i< n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int element = queue.peek();
            queue.poll();

            safeNodes.add(element);

            for(int num : adjRev.get(element)){
                inDegree[num] --;
                if(inDegree[num] == 0){
                    queue.add(num);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}

package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class DIJ_Pair{
    int node;
    int distance;
    public DIJ_Pair(int distance,int node){
        this.node = node;
        this.distance = distance;
    }
}

public class Dijkstras_Algorithm_PriorityQueue {
    public static int[] Dijkstras_Shortest_Path(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){

        PriorityQueue<DIJ_Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int[] dist = new int[V];

        Arrays.fill(dist, (int) 1e9);

        dist[S] = 0;
        pq.add(new DIJ_Pair(0, S));

        while(!pq.isEmpty()){
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            for (ArrayList<Integer> arr : adj.get(node)) {
                int edgeWeight = arr.get(1);
                int adjNode = arr.get(0);

                if(distance + edgeWeight < dist[adjNode]){
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new DIJ_Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}

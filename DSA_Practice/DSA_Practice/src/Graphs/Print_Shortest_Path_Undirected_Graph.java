package Graphs;

import java.util.*;

class ShortestPathPair{
    int node;
    int distance;

    public ShortestPathPair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
public class Print_Shortest_Path_Undirected_Graph {
    public static List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<ShortestPathPair>> adj = new ArrayList<>();
        for (int i = 0; i <= n ; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new ShortestPathPair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new ShortestPathPair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<ShortestPathPair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int [] dist = new int[n + 1];
        int [] parent = new int[n + 1];

        for (int i = 0; i <= n ; i++) {
            dist[i] = (int)1e9;
            parent[i] = i;
        }

        dist[1] = 0;
        pq.add(new ShortestPathPair(1, 0));

        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            pq.remove();

            for (ShortestPathPair iter : adj.get(node)){
                int adjNode = iter.node;
                int adjDist = iter.distance;

                if(distance + adjDist < dist[adjNode]){
                    dist[adjNode] = distance + adjDist;
                    pq.add(new ShortestPathPair(adjNode, distance + adjDist));

                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9){
            path.add(-1);
            return path;
        }

        int node = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;

    }
}

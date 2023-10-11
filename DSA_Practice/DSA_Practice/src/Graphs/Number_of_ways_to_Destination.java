package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class DestinationPair{
    int node;
    long distance;

    public DestinationPair(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}
public class Number_of_ways_to_Destination {
    public static int countPaths(int n, int[][] roads) {
        int m = roads.length;
        PriorityQueue<DestinationPair> priorityQueue = new PriorityQueue<>((x, y) -> (int)(x.distance - y.distance));

        ArrayList<ArrayList<DestinationPair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new DestinationPair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new DestinationPair(roads[i][0], roads[i][2]));
        }

        long [] dist = new long[n];
        int [] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        ways[0] = 1;
        dist[0] = 0;

        priorityQueue.add(new DestinationPair(0, 0));
        int mod = (int)(1e9 + 7);

        while (!priorityQueue.isEmpty()){
            int node = priorityQueue.peek().node;
            long distance = priorityQueue.peek().distance;
            priorityQueue.poll();

            for (DestinationPair iterator : adj.get(node)){
                int adjNode = iterator.node;
                long edgeWeight = iterator.distance;

                if (distance + edgeWeight < dist[adjNode]){
                    dist[adjNode] = distance + edgeWeight;
                    priorityQueue.add(new DestinationPair(adjNode, distance + edgeWeight));
                    ways[adjNode] = ways[node];
                }
                else if(distance + edgeWeight == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] +  ways[node]) % mod;
                }
            }

        }
        return ways[n - 1] % mod;
    }
}

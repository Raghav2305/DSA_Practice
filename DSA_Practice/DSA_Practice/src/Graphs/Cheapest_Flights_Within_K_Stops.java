package Graphs;

import java.util.*;

class FlightPair{
    int first, second;

    public FlightPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Tuple{
    int stops, node, distance;

    public Tuple(int stops, int node, int distance) {
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }
}
public class Cheapest_Flights_Within_K_Stops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<FlightPair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new FlightPair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while(!queue.isEmpty()){
            Tuple tuple = queue.peek();
            queue.poll();
            int stops = tuple.stops;
            int node = tuple.node;
            int price  = tuple.distance;

            if(stops > k){
                continue;
            }

            for (FlightPair iterator : adj.get(node)){
                int adjNode = iterator.first;
                int edgeWeight = iterator.second;

                if(price + edgeWeight < dist[adjNode]){
                    dist[adjNode] = price + edgeWeight;
                    queue.add(new Tuple(stops + 1, adjNode, price + edgeWeight));
                }
            }
        }
        if(dist[dst] == 1e9){
            return -1;
        }

        return dist[dst];
    }
}

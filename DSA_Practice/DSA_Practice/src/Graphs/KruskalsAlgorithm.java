package Graphs;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge>{
    int src, weight, target;

    public Edge(int src, int target, int weight) {
        this.src = src;
        this.weight = weight;
        this.target = target;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class KruskalsAlgorithm {
    public static int spanningTree(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int weight = adj.get(i).get(j).get(1);
//                int node = i;
                Edge temp = new Edge(i, adjNode, weight);
                edges.add(temp);
            }
        }
        Collections.sort(edges);
        int sum = 0;

        DisJoint_Set ds = new DisJoint_Set(V);

        for (int i = 0; i < edges.size(); i++) {
            int node = edges.get(i).src;
            int target = edges.get(i).target;
            int wt = edges.get(i).weight;

            if(ds.findUPar(node) != ds.findUPar(target)){
                sum += wt;
                ds.unionBySize(node, target);
            }

        }
        return sum;

    }
}

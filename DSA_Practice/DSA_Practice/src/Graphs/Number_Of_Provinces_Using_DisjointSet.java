package Graphs;

import java.util.ArrayList;

public class Number_Of_Provinces_Using_DisjointSet {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int m = isConnected.length;

        for (int i = 0; i < m ; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        DisJoint_Set ds = new DisJoint_Set(adj.size());
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.size(); j++) {
                if(adj.get(i).get(j) == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < adj.size(); i++) {
            if(ds.findUPar(i) == i){
                count++;
            }
        }
        return count;
    }
}

package Graphs;

public class Make_Network_Connected {
    public int makeConnected(int n, int[][] connections) {
        int extraEdges = 0;
        DisJoint_Set ds = new DisJoint_Set(n);
        for (int i = 0; i < n; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUPar(u) == ds.findUPar(v)){
                extraEdges++;
            }
            else{
                ds.unionBySize(u, v);
            }
        }

        int numberOfComponents = 0;


        for (int i = 0; i < n; i++) {
            if(ds.parent.get(i) == i){
                numberOfComponents++;
            }
        }

        int ans = numberOfComponents - 1;
        if(extraEdges >= ans){
            return ans;
        }else{
            return -1;
        }
    }
}

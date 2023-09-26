package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {

    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
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
    public static String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N -1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < len; ptr++) {
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        int[] topoSort = topoSort(K, adj);
        String ans = "";

        for(int num : topoSort){
            ans = ans + (char)(num - 'a');
        }

        return ans;
    }
}

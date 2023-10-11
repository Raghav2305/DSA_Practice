package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class MultiplicationsPair{
    int first, second;
    public MultiplicationsPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Minimum_Number_of_multiplications {
    public static int minimumMultiplications(int[] arr, int start, int end) {
        Queue<MultiplicationsPair> queue = new LinkedList<>();
        int[] dist = new int[100000];
        Arrays.fill(dist, (int)1e9);

        queue.add(new MultiplicationsPair(start, 0));
        dist[start] = 0;
        int mod = 100000;

        while(!queue.isEmpty()){
            int node = queue.peek().first;
            int steps = queue.peek().second;
            queue.poll();

            for (int i = 0; i < arr.length; i++) {
                int num = (arr[i] * node) % mod;
                if(steps + 1 < dist[node]){
                    dist[node] = steps + 1;
                    if(node == end){
                        return steps + 1;
                    }
                    queue.add(new MultiplicationsPair(node, steps + 1));
                }
            }

        }
        return -1;
    }
}

package Graphs;

import java.util.ArrayList;
import java.util.Arrays;


public class Network_Delay_Time {
    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            for (int[] time: times) {
                if (dist[time[0] - 1] + time[2] < dist[time[1] - 1]) {
                    dist[time[1] - 1] = dist[time[0] - 1] + time[2];
                }
            }
        }
        boolean hasInfinite = false;
        for (int i : dist) {
            if (i == (int)1e9) {
                hasInfinite = true;
                break;
            }
        }
        if (hasInfinite) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        for (int i : dist) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}

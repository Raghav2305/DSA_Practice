package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Same_Tree {





    public void BFS(int src, ArrayList<ArrayList<Integer>>adj, int[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = 1;

        while(q.size()>0){
            int ele = q.poll();
            for (Integer it: adj.get(ele)
                 ) {
                if (visited[it] == 0){
                    visited[it] = 1;
                    q.add(it);
                }
            }
        }
    }


}

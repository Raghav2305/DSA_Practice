package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    public static void main(String[] args) {

    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                if (checkCycle(i, -1, vis, adj)){
                    return true;
                }

            }

        }
        return false;

    }

    private boolean checkCycle(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (Integer it: adj.get(node)){
            if (!vis[it]){
                if(checkCycle(it, node, vis, adj)){
                    return true;
                }
            else if(parent!=it){
                return true;
                }
            }
        }
        return false;




    }
}
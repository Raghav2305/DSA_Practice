package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        // for (int i = 0; i < prerequisites.length; i++) {
        //     for(int num : adj.get(i)){
        //         inDegree[num] ++;
        //     }
        // }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        int i = 0;
        while (!queue.isEmpty()){
            int element = queue.peek();
            queue.poll();

            topo.add(element);

            for(int num : adj.get(element)){
                inDegree[num] --;
                if(inDegree[num] == 0){
                    queue.add(num);
                }
            }
        }

        if(topo.size() == numCourses) return true;
        return false;
    }
}

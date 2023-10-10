package Graphs;

import java.util.PriorityQueue;

class PathPair{
    int distance, row, column;

    public PathPair(int distance, int row, int column) {
        this.distance = distance;
        this.row = row;
        this.column = column;
    }
}
public class Path_with_Minimum_Effort {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<PathPair> priorityQueue = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int n = heights.length;
        int m = heights[0].length;
        int [][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int)1e9;
            }
        }

        dist[0][0] = 0;
        priorityQueue.add(new PathPair(0, 0, 0));

        int [] dr = {-1, 0, 1, 0};
        int [] dc = {0, 1, 0, -1};

        while(!priorityQueue.isEmpty()){
            PathPair tuple = priorityQueue.peek();
            priorityQueue.poll();
            int distance = tuple.distance;
            int row = tuple.row;
            int column = tuple.column;

            if(row == n-1 && column == m-1){
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = column + dc[i];

                if(newRow >=0 && newCol >=0 && newRow < n && newCol < m){
                    int newEffort = Math.max(
                            Math.abs(heights[row][column] - heights[newRow][newCol]), distance);
                    if(newEffort < dist[newRow][newCol]){
                        dist[newRow][newCol] = newEffort;
                        priorityQueue.add(new PathPair(newEffort, newRow, newCol));
                    }
                }

            }
        }
        return 0;
    }
}

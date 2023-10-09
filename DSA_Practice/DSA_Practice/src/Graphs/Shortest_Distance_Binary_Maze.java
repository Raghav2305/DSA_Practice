package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class tuple{
    int distance, row, column;

    public tuple(int distance, int row, int column) {
        this.distance = distance;
        this.row = row;
        this.column = column;
    }
}
public class Shortest_Distance_Binary_Maze {
    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1]){
            return 0;
        }

        Queue<tuple> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int [][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int)1e9;
            }
        }

        dist[source[0]][source[1]] = 0;
        queue.add(new tuple(0, source[0], source[1]));
        int [] dr = {-1, 0, 1, 0};
        int [] dc = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            tuple iterator = queue.peek();
            queue.remove();

            int distance = iterator.distance;
            int row = iterator.row;
            int column = iterator.column;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = column + dc[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && distance + 1 < dist[newRow][newCol]){
                    dist[newRow][newCol] = distance + 1;
                    if(destination[0] == newRow && destination[1] == newCol){
                        return distance + 1;
                    }
                    queue.add(new tuple(1 + distance, newRow, newCol));
                }
            }
        }
        return -1;
    }
}

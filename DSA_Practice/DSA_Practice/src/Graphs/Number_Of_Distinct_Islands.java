package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class Number_Of_Distinct_Islands {

    private static String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    private static void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> arr, int start_row, int start_col){
        vis[row][col] = 1;
        arr.add(toString(row - start_row, col - start_col));

        int n = grid.length;;
        int m = grid[0].length;

        for (int delRow = -1 ; delRow <= 1 ; delRow++) {
            for (int delCol = -1; delCol <= 1; delCol++) {
                int neighbour_row = row + delRow;
                int neighbour_col = col + delCol;

                if( neighbour_row >= 0 && neighbour_row < n
                        && neighbour_col >= 0 && neighbour_col < m
                        && vis[neighbour_row][neighbour_col] == 0
                        && grid[neighbour_row][neighbour_col] == 1){
                    dfs(neighbour_row, neighbour_col, vis, grid, arr, start_row, start_col);
                }
            }
        }


    }
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        ArrayList<String> arr = new ArrayList<>();
        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    dfs(i, j, vis, grid, arr, i, j);
                    set.add(arr);
                }
            }
        }
        return set.size();
    }
}

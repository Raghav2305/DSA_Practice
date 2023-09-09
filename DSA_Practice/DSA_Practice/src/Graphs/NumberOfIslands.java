package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair_Islands{
    int first, second;
    public Pair_Islands(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIslands {
    private static void bfs(int row, int col, boolean[][] vis, char[][] grid){
        vis[row][col] = true;
        Queue<Pair_Islands> queue = new LinkedList<>();
        queue.offer(new Pair_Islands(row, col));

        int num_of_rows = grid.length;
        int num_of_cols = grid[0].length;

        while (!queue.isEmpty()){
            int first = queue.peek().first;
            int second = queue.peek().second;
            queue.remove();

            for (int delRow = -1 ; delRow <= 1 ; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int neighbour_row = first + delRow;
                    int neighbour_col = second + delCol;

                    if( neighbour_row >= 0 && neighbour_row < num_of_rows
                            && neighbour_col >= 0 && neighbour_col < num_of_cols
                            && !vis[neighbour_row][neighbour_col]
                            && grid[neighbour_row][neighbour_col] == '1'){
                        vis[neighbour_row][neighbour_col] = true;
                        queue.add(new Pair_Islands(neighbour_row, neighbour_col));
                    }
                }
            }


        }
    }

    public static  int numIslands(char[][] grid) {
        int row_len = grid.length;
        int col_len = grid[0].length;

        boolean[][] vis = new boolean[row_len][col_len];
        int num_of_islands = 0;

        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                if(grid[i][j] == '1' && !vis[i][j]){
                    num_of_islands++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return num_of_islands;
    }

    public static void main(String[] args) {
        char[][] grid =  {
          {'1','1','1','1','0'},
          {'1','1','0','1','0'},
          {'1','1','0','0','0'},
          {'0','0','0','0','0'}
        };

        int ans = numIslands(grid);
        System.out.println(ans);
    }
}

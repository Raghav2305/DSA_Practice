package Graphs;

import java.sql.Time;

public class Number_Of_Enclaves {

    static void dfs(int row, int col, int[][] mat, boolean[][] vis) {
        vis[row][col] = true;
        int n = mat.length;
        int m = mat[0].length;

        for (int delRow = -1; delRow <=1 ; delRow++) {
            for (int delCol = -1; delCol <=1 ; delCol++) {
                if(delRow == 0 || delCol == 0){
                    int nrow = row + delRow;
                    int ncol = col + delCol;

                    if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m
                            && !vis[nrow][ncol] && mat[nrow][ncol] == 1) {
                        dfs(nrow, ncol, mat, vis);
                    }
                }
            }
        }
    }
    public static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            // First column.
            if (grid[i][0] == 1 && !visit[i][0]) {
                dfs(i, 0, grid, visit);
            }
            // Last column.
            if (grid[i][n - 1] == 1 && !visit[i][n - 1]) {
                dfs(i, n - 1,  grid, visit);
            }
        }

        for (int i = 0; i < n; ++i) {
            // First row.
            if (grid[0][i] == 1 && !visit[0][i]) {
                dfs(0, i,  grid, visit);
            }
            // Last row.
            if (grid[m - 1][i] == 1 && !visit[m - 1][i]) {
                dfs(m - 1, i,  grid, visit);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

//    Time Complexity: O(NxMx4) ~ O(N x M), For the worst case, assuming all the pieces as land, the BFS function will be called for (N x M) nodes and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time.
//
//    Space Complexity ~ O(N x M), O(N x M) for the visited array, and queue space takes up N x M locations at max.

    public static void main(String[] args) {
        int[][] grid = {{0},{1},{1},{0}, {0}};
        int ans = numEnclaves(grid);
        System.out.println(ans);
    }
}


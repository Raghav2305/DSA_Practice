package Graphs;

import java.sql.Time;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int row, col, steps;

    public Node(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

public class Nearest_Cell_Having_1 {
    public static int[][] nearest_1(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    queue.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }

        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int step = queue.peek().steps;

            queue.remove();

            dis[row][col] = step;

            for (int delRow = -1; delRow <=1 ; delRow++) {
                for (int delCol = -1; delCol <=1 ; delCol++) {
                    if(delRow == 0 || delCol == 0){
                        int nRow = row + delRow;
                        int nCol = col + delCol;

                        if(nRow >=0 && nRow < n && nCol >=0 && nCol < m && vis[nRow][nCol] == 0){
                            vis[nRow][nCol] = 1;
                            queue.add(new Node(nRow, nCol, step + 1));
                        }
                    }
                }
            }
        }
        return dis;
    }

//    Time Complexity: O(NxM + NxMx4) ~ O(N x M) -> For the worst case, the BFS function will be called for (N x M) nodes, and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time.

//    Space Complexity: O(N x M) + O(N x M) + O(N x M) ~ O(N x M)
//    O(N x M) for the visited array, distance matrix, and queue space takes up N x M locations at max.

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };

        int[][] res =  nearest_1(grid);
        System.out.print(Arrays.deepToString(res));
    }
}

package Graphs;

import java.util.Arrays;

public class FloodFillAlgorithm {
    private static void dfs(int sr, int sc, int[][] ans, int color, int[][] image, int initialColor){
        ans[sr][sc] = color;
        int n = ans.length;
        int m = ans[0].length;

        for (int delRow = -1 ; delRow <= 1 ; delRow++) {
            for (int delCol = -1; delCol <= 1; delCol++) {
                if(delRow == 0 || delCol == 0){
                    int nRow = sr + delRow;
                    int nCol = sc + delCol;
                    if(nRow >= 0 && nRow < n && nCol >=0 && nCol < m
                            && image[nRow][nCol] == initialColor && ans[nRow][nCol]                  !=   color){
                        dfs(nRow, nCol, ans, color, image, initialColor );
                    }
                }
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[][] ans = image;

        dfs(sr, sc, ans, color, image, initialColor);
        return ans;
    }

    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int start_row = 1;
        int start_col = 1;
        int color = 2;

        int[][] res = floodFill(image, start_row, start_col, color);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<Integer> generateRow(int row){
        long ans = 1;
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            newRow.add((int) ans);
        }
        return newRow;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows ; i++) {
            ans.add(generateRow(i));
        }
        return ans;
    }
}

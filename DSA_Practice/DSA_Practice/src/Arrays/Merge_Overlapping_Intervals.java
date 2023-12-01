package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


// Optimal Force
// TC - O(NlogN) + O(N)
// SC - O(N)
public class Merge_Overlapping_Intervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length; // size of the array
    // sort the given intervals:
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
        } else {
            ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
        }
        }

    int[][] ansArray = ans.toArray(new int[ans.size()][]);
    return ansArray;
   }
}




    // Brute Force
    // TC - O(NlogN) + O(2N)
    // SC - O(N)
//    public int[][] merge(int[][] intervals) {
//        int n = intervals.length;
//        Arrays.sort(intervals);
//        int[][] ans = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            int start = intervals[i][0];
//            int end = intervals[i][1];
//
//            if(ans.length != 0 && end <= ans[ans.length - 1][1]){
//                continue;
//            }
//
//            for (int j = i+1; j <n ; j++) {
//                if(intervals[j][0] <= end){
//                    end = Math.max(end, intervals[j][1]);
//                }
//                else{
//                    break;
//                }
//            }
//            ans[i] = new int[]{start, end};
//        }
//        return ans;
//    }
//}

package Arrays;

import java.util.HashMap;

public class Largest_SubArray_With_Sum_K {
    public static int longestSubArrayWithSumK(int []a, long k) {
        int maxi = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if(sum == k){
                maxi = i + 1;
            }
            else if(map.get(sum) != null){
                maxi = Math.max(maxi, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return maxi;
    }
}

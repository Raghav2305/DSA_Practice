package Arrays;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int initial = nums[i];
            int required = target - initial;
            if (map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }
            map.put(initial, i);
        }

        return new int[]{-1, -1};
    }
}

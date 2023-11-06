package Arrays;

import java.util.HashMap;

public class Majority_Element {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }

            map.put(nums[i], 1);
        }

        int majorityCount = len / 2;
        int max = Integer.MIN_VALUE;

        for (int num : map.keySet()){
            if(map.get(num) > majorityCount){
                return num;
            }
        }
        return -1;
    }
}

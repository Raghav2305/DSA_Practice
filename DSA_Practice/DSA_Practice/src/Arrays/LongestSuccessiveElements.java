package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class LongestSuccessiveElements {
    public int longestConsecutive(int[] nums) {
        int lastSmaller = Integer.MIN_VALUE;
        int longestSequence = 1;
        int currCount = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 == lastSmaller){
                currCount++;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                currCount = 1;
                lastSmaller = nums[i];
            }

            longestSequence = Math.max(currCount, longestSequence);
        }
        return longestSequence;
    }
}

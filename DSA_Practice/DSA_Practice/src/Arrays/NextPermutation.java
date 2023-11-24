package Arrays;


import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;

        for (int i = n-2 ; i >=0 ; i--) {
            if(nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            Collections.reverse(Arrays.asList(nums));

        }

        for (int i = n-1; i > index ; i++) {
            if(nums[i] > nums[index]) {
                Collections.swap(Arrays.asList(nums), i, index);
                break;
            }
        }

        List sublist = Arrays.asList(nums).subList(index + 1, n);
        Collections.reverse(sublist);
    }


}

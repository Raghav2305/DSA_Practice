package Arrays;

import java.util.HashSet;
import java.util.Set;

public class Find_Missing_Number {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int missingNumber = 0;

        int [] check = new int[n + 1];
        for(int i = 0; i<=n; i++){
            check[i] = i;
        }

        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }

        for(int num: check){
            if(!set.contains(num)){
                missingNumber = num;
                break;
            }
        }
        return missingNumber;
    }
}

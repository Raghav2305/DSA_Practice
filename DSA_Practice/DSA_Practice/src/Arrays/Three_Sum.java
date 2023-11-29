package Arrays;

import java.lang.reflect.Array;
import java.util.*;

// Optimal Solution
// TC -> O(NlogN) + O(N ^ 2)
// SC -> O(number of triplets) = O(1)
public class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                }
            }

        }
        return ans;
    }
}


// Better Approach
// TC -> O(N ^ 2) * (log N) for the map
// SC -> O(N) + O(number of triplets) = we need to reduce this

//--------------------------------------------------------------------
//    public List<List<Integer>> threeSum(int[] nums) {
//
//        Set<List<Integer>> ansSet = new HashSet<List<Integer>>();
//
//        for (int i = 0; i < nums.length; i++) {
//            Set<Integer> hashSet = new HashSet<Integer>();
//            for (int j = i+1; j < nums.length ; j++) {
//                int third = - (nums[i] + nums[j]);
//                if(hashSet.contains(third)) {
//                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
//                    temp.sort(null);
//                    ansSet.add(temp);
//                }
//                hashSet.add(nums[j]);
//            }
//        }
//        List<List<Integer>> ans = new ArrayList<>(ansSet);
//        return ans;
//
//    }


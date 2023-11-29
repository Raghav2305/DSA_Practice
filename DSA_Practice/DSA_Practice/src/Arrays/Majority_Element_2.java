package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Majority_Element_2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else{
                map.put(num, 1);
            }
        }

        int maxCount = n / 3;
        List<Integer> ans = new ArrayList<>();

        for(int num : map.keySet()){
            if(map.get(num) > maxCount){
                ans.add(num);
            }
        }
        return ans;
    }
}

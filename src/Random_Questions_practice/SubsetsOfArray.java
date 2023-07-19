package Random_Questions_practice;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList());


        for(int i=0; i<nums.length; i++){
            int ansSize = ans.size();
            for(int j=0; j<ansSize; j++){
                ArrayList<Integer> temp = new ArrayList(ans.get(j));
                System.out.println(ans.get(j));
                temp.add(nums[i]);
                ans.add(temp);
            }
        }

        return ans;
    }
}

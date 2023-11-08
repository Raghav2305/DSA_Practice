package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Rearrange_Array_Elements_By_Sign {
    public static int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for(int num : nums){
            if(num < 0){
                negative.add(num);
            }
            if(num > 0){
                positive.add(num);
            }
        }

        int p = 0, q = 0;

        ArrayList<Integer> rearranged = new ArrayList<>();
        while (p < positive.size() && q < negative.size()){
            rearranged.add(positive.get(p));
            rearranged.add(negative.get(q));
            p++;
            q++;
        }

//        while (p < positive.size()) {
//            rearranged.add(positive.get(p));
//            p++;
//        }
//        while (q < negative.size()) {
//            rearranged.add(negative.get(q));
//            q++;
//        }

        int[] result = new int[rearranged.size()];
        for (int i = 0; i < rearranged.size(); i++) {
            result[i] = rearranged.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int [] nums = {3,1,-2,-5,2,-4};
        int [] ans = rearrangeArray(nums);
        System.out.println(Arrays.toString(ans));
    }
}

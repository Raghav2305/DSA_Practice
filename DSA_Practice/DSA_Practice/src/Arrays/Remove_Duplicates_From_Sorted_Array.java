package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Remove_Duplicates_From_Sorted_Array {

    public static int removeDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr){
            set.add(num);
        }

        System.out.println(set.size());
        return set.size();
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 2, 3, 3, 3, 4, 4, 5, 5 };
        int ans = removeDuplicates(arr);
        System.out.println(ans);
    }
}

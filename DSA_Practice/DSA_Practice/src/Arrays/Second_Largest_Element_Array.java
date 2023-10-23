package Arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Second_Largest_Element_Array {
    public static int[] getSecondOrderElements(int n, int []a) {

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arr.add(a[i]);
        }

        Collections.sort(arr);
        int[] ans = new int[2];

        ans[0] = arr.get(arr.size() - 2);
        ans[1] = arr.get(1);
        return ans;
    }
}

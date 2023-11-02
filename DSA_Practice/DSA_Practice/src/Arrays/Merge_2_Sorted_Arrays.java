package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Merge_2_Sorted_Arrays {
    public static List< Integer > sortedArray(int []a, int []b) {
        Set<Integer> s = new TreeSet<>();

        for (int num : a) {

            s.add(num);

        }

        for (int num : b) {

            s.add(num);

        }

        List<Integer> res = new ArrayList<>(s);

        return res;
    }
}

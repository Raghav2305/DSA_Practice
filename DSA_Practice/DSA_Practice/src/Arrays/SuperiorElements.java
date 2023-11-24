package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperiorElements {
    public List< Integer > superiorElements(int []a) {
        int n = a.length;
        List<Integer> ans = new ArrayList<>();
        int maxTillNow = a[n - 1];
        ans.add(maxTillNow);

        for (int i = n - 2; i >= 0 ; i--) {
            if(a[i] > maxTillNow){
                ans.add(maxTillNow);
                maxTillNow = a[i];
            }
        }

        Collections.sort(ans);
        return ans;
    }


}

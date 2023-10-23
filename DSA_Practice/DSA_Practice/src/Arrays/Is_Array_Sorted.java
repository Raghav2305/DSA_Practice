package Arrays;

public class Is_Array_Sorted {
    public static int isSorted(int n, int []a) {
        int count = 0;
        for (int i = 0; i < a.length -1; i++) {
            if(a[i] <= a[i+1]){
                count++;
            }
        }

        if(count == a.length - 1){
            return 1;
        }

        return 0;

    }
}

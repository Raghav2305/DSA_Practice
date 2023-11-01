package Arrays;

import java.util.Arrays;

public class Rotate_Array {
    public static int[] rotate(int[] nums, int k) {
        int length = nums.length;
        k = k% length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);

        return nums;
    }

    public static void reverse(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        System.out.println(Arrays.toString(rotate(nums, k)));


    }
}

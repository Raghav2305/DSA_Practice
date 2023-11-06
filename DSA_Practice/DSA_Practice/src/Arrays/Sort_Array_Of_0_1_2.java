package Arrays;

public class Sort_Array_Of_0_1_2 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int low = 0, mid = 0, high = len - 1 ;

        while(mid<= high) {
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;

            }
        }
    }
}

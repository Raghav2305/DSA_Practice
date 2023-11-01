package Arrays;

public class Move_Zero_to_end {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int count = 0;

        for(int num : nums){
            if(num != 0){
                nums[count] = num;
                count++;
            }
        }

        while(count < length){
            nums[count] = 0;
            count++;
        }
    }
}

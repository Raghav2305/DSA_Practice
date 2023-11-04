package Arrays;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {

        int longest = 0;
        int currCount = 0;

        for(int i=1; i<= nums.length; i++){
            if(nums[i - 1] == 1){
                currCount++;
            }
            else if(nums[i - 1] != 1){
                currCount = 0;
            }

            longest = Math.max(longest, currCount);
        }
        return longest;
    }
}

package Random_Questions_practice;

public class largest_element_twice_as_every {
    public int dominantIndex(int[] nums) {

        int len = nums.length;

        if(len < 2){
            return -1;
        }
        int largest = 0;
        int largest_index = 0;

        for(int i = 0; i < len; i++){
            if(nums[i] > largest){
                largest = nums[i];
                largest_index = i;
            }
        }

        for (int num : nums) {
            if(num == largest){
                continue;
            }
            if (largest < 2 * num) {
                return -1;
            }
        }

        return largest_index;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,1,0};
        largest_element_twice_as_every obj = new largest_element_twice_as_every();
        int ans = obj.dominantIndex(nums);
        System.out.println(ans);
    }
}


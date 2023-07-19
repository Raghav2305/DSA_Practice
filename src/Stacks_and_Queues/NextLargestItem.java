package Stacks_and_Queues;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestItem {
    public int[] nextLarge(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int [] nextGreaterArray = new int[n];
        for (int i = (2*n - 1); i >=0  ; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i % n]){
                stack.pop();
            }

            if(i < n){
                if(!stack.isEmpty()){
                    nextGreaterArray[i] = stack.peek();
                }else{
                    nextGreaterArray[i] = -1;
                }
            }
            stack.push(arr[i % n]);
        }
        return nextGreaterArray;
    }

    public static void main(String[] args) {
        NextLargestItem obj = new NextLargestItem();
        int[] arr = {5,7,1,2,6,0};
        int[] ans = obj.nextLarge(arr);
        System.out.println(Arrays.toString(ans));
    }
}

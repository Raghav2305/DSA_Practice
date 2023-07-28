package Stacks_and_Queues;

import java.util.Stack;

public class LargestHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int [] leftSmall = new int[n];
        int [] rightSmall = new int[n];
        int maxArea = 0;

        for (int i = 0; i < n ; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                leftSmall[i] = 0;
            }else{
                leftSmall[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            stack.pop();
        }

        for (int i = n - 1; i >= 0 ; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                rightSmall[i] = n - 1;
            }else{
                rightSmall[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestHistogram lh = new LargestHistogram();
        int [] arr = {2,4};
        System.out.println(lh.largestRectangleArea(arr));
    }
}

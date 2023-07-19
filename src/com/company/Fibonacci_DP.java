package com.company;

public class Fibonacci_DP {
    public static void main(String[] args) {
        int ans = calc(7);
        System.out.println(ans);
    }

    public static int calc(int n) {
        int prev = 1;
        int prev2 = 0;

        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}

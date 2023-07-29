package com.company;

class Jump {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 0, 4 };
        boolean ans = jump(arr);
        System.out.println(ans);
    }

    public static boolean jump(int arr[]) {
        int goal = arr.length - 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i + arr[i] >= goal) {
                goal = i;
            }
        }

        if (goal == 0) {
            return true;
        } else {
            return false;
        }

    }
}
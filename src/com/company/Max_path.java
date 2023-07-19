package com.company;

public class Max_path {
    int val;
    Max_path left, right;
    static int max;

    public Max_path(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public static int max_path(Max_path root){

        if (root == null){
            return 0;
        }

        int left_path = max_path(root.left);
        int right_path = max_path(root.right);

        max = Math.max(max, left_path + right_path + root.val);

        return (root.val) + Math.max(left_path, right_path);
    }

    public static void main(String[] args) {
        max = 0;
        Max_path root = new Max_path(1);
        root.left = new Max_path(2);
        root.right = new Max_path(3);
//        root.right.left = new Max_path(15);
//        root.right.right = new Max_path(7);
//        root.right.right.left = new Max_path(8);

        max_path(root);
        System.out.println("The max Path is : " + max);

    }
}

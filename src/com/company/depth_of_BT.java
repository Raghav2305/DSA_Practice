package com.company;

public class depth_of_BT {
    int val;
    depth_of_BT left, right;

    public depth_of_BT(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public static int height(depth_of_BT root){
        if (root == null){
            return 0;
        }

        int left_h = height(root.left);
        int right_h = height(root.right);

        return 1 + Math.max(left_h, right_h);
    }

    public static void main(String[] args) {
        depth_of_BT root = new depth_of_BT(1);
        root.left = new depth_of_BT(2);
        root.right = new depth_of_BT(3);
        root.right.left = new depth_of_BT(4);
        root.right.right = new depth_of_BT(6);
        root.right.left.left = new depth_of_BT(5);

        int ans = height(root);
        System.out.println("The max height is : " + ans);
    }
}

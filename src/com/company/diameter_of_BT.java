package com.company;
public class diameter_of_BT {
    int val;
    static int diameter;
    diameter_of_BT left, right;

    public diameter_of_BT(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public static int diameter(diameter_of_BT root){
        diameter = 0;
        height(root);
        return diameter;

    }

    private static int height(diameter_of_BT root) {
        if(root == null){
            return 0;
        }
        int left_h = height(root.left);
        int right_h = height(root.right);
        diameter = Math.max(diameter, left_h+right_h);

        return Math.max(left_h, right_h) + 1;
    }

    public static void main(String[] args) {
        diameter_of_BT root = new diameter_of_BT(1);
        root.left = new diameter_of_BT(2);
        root.right = new diameter_of_BT(3);
        root.right.left = new diameter_of_BT(4);
        root.right.left.left = new diameter_of_BT(5);
        root.right.left.left.left = new diameter_of_BT(9);
        root.right.right = new diameter_of_BT(6);
        root.right.right.right = new diameter_of_BT(7);
        root.right.right.right.right = new diameter_of_BT(8);

        int ans = diameter(root);
        System.out.println("The diameter of the tree is : " + ans);

    }
}

package com.company;

public class check_balanced_BT {
    int val;
    check_balanced_BT left, right;

    public check_balanced_BT(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public static boolean is_balanced(check_balanced_BT root){
        return height(root) != -1;
    }

    private static int height(check_balanced_BT root) {
        if (root == null){
            return 0;
        }
       int left_h = height(root.left);
       if (left_h == -1){
           return -1;
       }

        int right_h = height(root.right);
       if (right_h == -1) return -1;

       if(Math.abs(left_h - right_h) > 1){
           return -1;
       }
       return Math.max(left_h, right_h) +1;

    }

    public static void main(String[] args) {
        check_balanced_BT root = new check_balanced_BT(1);
        root.left = new check_balanced_BT(2);
        root.right = new check_balanced_BT(3);
        root.right.left = new check_balanced_BT(4);
        root.right.right = new check_balanced_BT(5);
//        root.right.right.right = new check_balanced_BT(6);
//        root.right.right.right.right = new check_balanced_BT(7);

        boolean ans = is_balanced(root);
        if (!ans){
            System.out.println("Not balanced Tree");
        }
        else{
            System.out.println("It's a balanced tree");
        }


    }
}

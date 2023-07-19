package com.company;

import java.util.*;

public class ZigZag_traversal {
    int val;
    ZigZag_traversal left, right;

    public ZigZag_traversal(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public static List<List<Integer>> Z_traversal(ZigZag_traversal root){
        List<List<Integer>> my_ans = new LinkedList<>();
        Queue<ZigZag_traversal> q = new LinkedList<>();

        if (root == null){
            return my_ans;
        }

        q.offer(root);
        boolean left_to_right = true;

        while(!q.isEmpty()){
            int ele = q.size();
            List<Integer> sublist = new LinkedList<Integer>();

            for (int i = 0; i < ele; i++) {
                if(q.peek().left != null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right != null){
                    q.offer(q.peek().right);
                }

                sublist.add(q.poll().val);

            }
            if(!left_to_right){
                Collections.reverse(sublist);
            }


            my_ans.add(sublist);
            left_to_right = !(left_to_right);


        }
        return my_ans;
    }

    public static void main(String[] args) {
        ZigZag_traversal root = new ZigZag_traversal(1);
        root.left = new ZigZag_traversal(2);
        root.right = new ZigZag_traversal(3);
        root.left.left = new ZigZag_traversal(4);
        root.left.right = new ZigZag_traversal(5);
//        root.left.right.left = new ZigZag_traversal(8);
        root.right.left = new ZigZag_traversal(6);
        root.right.right = new ZigZag_traversal(7);
//        root.right.right.left = new ZigZag_traversal(9);
//        root.right.right.right = new ZigZag_traversal(10);

        List<List<Integer>> ans =  Z_traversal(root);

        for (List<Integer> an : ans) {
            System.out.println(an + " ");
        }
    }
}

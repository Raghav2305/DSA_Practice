package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

//    public TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }

    public static List<List<Integer>> traverse(TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if (root == null){
            return wrapList;
        }

        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> subList = new LinkedList<Integer>();

            for (int i = 0; i <level ; i++) {
                if(q.peek().left!=null){
                    q.offer(q.peek().left);

                }
                if(q.peek().right != null){
                    q.offer(q.peek().right);
                }

                subList.add(q.poll().val);
            }

            wrapList.add(subList);
        }
        return wrapList;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
//        root.right.right.left = new TreeNode(9);
//        root.right.right.right = new TreeNode(10);

        List<List<Integer>> ans =  traverse(root);

        for (List<Integer> an : ans) {
            System.out.println(an + " ");
        }
    }
}

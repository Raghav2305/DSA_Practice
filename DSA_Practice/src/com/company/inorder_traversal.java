package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode_Inorder {
     int val;
     TreeNode_Inorder left, right;

     public TreeNode_Inorder(int val) {
         this.val = val;
         left = null;
         right = null;
     }

     public static void recursive_inorder(TreeNode_Inorder curr,
                                          ArrayList<Integer> in_order){
         if(curr == null){
             return ;
         }
         recursive_inorder(curr.left, in_order);
         in_order.add(curr.val);
         recursive_inorder(curr.right, in_order);

     }

     public static List<Integer> iterative_inorder(TreeNode_Inorder root) {
         List<Integer> iterative_lst = new ArrayList<Integer>();
         Stack<TreeNode_Inorder> st = new Stack<TreeNode_Inorder>();
         TreeNode_Inorder node = root;
         while (true) {
             if (node != null) {
                 st.push(node);
                 node = node.left;
             } else {
                 if (st.isEmpty()) {
                     break;
                 }
                 node = st.pop();
                 iterative_lst.add(node.val);
                 node = node.right;
             }

         }
         return iterative_lst;
     }






    public static void main(String[] args) {
        TreeNode_Inorder root = new TreeNode_Inorder(1);
        root.left = new TreeNode_Inorder(2);
        root.right = new TreeNode_Inorder(3);
        root.left.left = new TreeNode_Inorder(4);
        root.left.right = new TreeNode_Inorder(5);
        root.left.right.left = new TreeNode_Inorder(8);
        root.right.left = new TreeNode_Inorder(6);
        root.right.right = new TreeNode_Inorder(7);
        root.right.right.left = new TreeNode_Inorder(9);
        root.right.right.right = new TreeNode_Inorder(10);

//        ArrayList<Integer> it_ans = new ArrayList<Integer>();
//        recursive_inorder(root, it_ans);
        List<Integer> it_ans = iterative_inorder(root);

        System.out.print("The inOrder Traversal is : ");
        for (int i = 0; i < it_ans.size(); i++) {
            System.out.println(it_ans.get(i) + " ");
        }
    }
 }

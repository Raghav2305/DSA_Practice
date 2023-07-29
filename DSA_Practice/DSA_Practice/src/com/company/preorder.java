//Recursive:

package com.company;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//class Node {
//    int data;
//    Node left;
//    Node right;
//
//    Node(int key) {
//        this.data = key;
//        left = null;
//        right = null;
//    }
//
//}
//
//class Traversal {
//    public static void pre_order(Node curr, ArrayList<Integer> preorder_list) {
//        if (curr == null) {
//            return;
//        }
//        preorder_list.add(curr.data);
//        pre_order(curr.left, preorder_list);
//        pre_order(curr.right, preorder_list);
//    }
//
//    public static void main(String[] args) {
//
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(8);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//        root.right.right.left = new Node(9);
//        root.right.right.right = new Node(10);
//
//        ArrayList<Integer> preorder = new ArrayList<>();
//        pre_order(root, preorder);
//
//        System.out.print("The preOrder Traversal is : ");
//        for (int i = 0; i < preorder.size(); i++) {
//            System.out.print(preorder.get(i) + " ");
//        }
//    }
//}

//Iterative:

class Node {
    int data;
    Node left;
    Node right;

    Node(int key) {
        this.data = key;
        left = null;
        right = null;
    }
}

class traversal{
    public static List<Integer> iterative_preorder(TreeNode root){
        List<Integer> preorder = new ArrayList<Integer>();

        if(root == null){
            return preorder;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            root = stack.pop();
            preorder.add(root.val);

            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
        }
        return preorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);


        List <Integer> pre_order = iterative_preorder(root);

        System.out.print("The preOrder Traversal is : ");
        for (int i = 0; i < pre_order.size(); i++) {
            System.out.println(pre_order.get(i) + " ");
        }
    }
}


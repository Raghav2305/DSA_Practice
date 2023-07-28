package com.company;

import java.util.ArrayList;

public class postorder {
    int data;
    Node left, right;

    public postorder(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static void traverse(Node curr, ArrayList<Integer> post_list){
        if (curr == null){
            return;
        }

        traverse(curr.left, post_list);
        traverse(curr.right, post_list);
        post_list.add(curr.data);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList <Integer> post_order = new ArrayList<>();
        traverse(root, post_order);

        System.out.print("The postOrder Traversal is : ");
        for (int i = 0; i < post_order.size(); i++) {
            System.out.println(post_order.get(i) + " ");
        }
    }
}

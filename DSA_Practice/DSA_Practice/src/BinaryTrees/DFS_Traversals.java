package BinaryTrees;

import java.util.ArrayList;

public class DFS_Traversals {
    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static void preorderTraversal(Node curr, ArrayList<Integer> preorder){
        if(curr == null){
            return;
        }

        preorder.add(curr.value);
        preorderTraversal(curr.left, preorder);
        preorderTraversal(curr.right, preorder);
    }

    public static void postorderTraversal(Node curr, ArrayList<Integer> postorder){
        if(curr == null){
            return;
        }

        postorderTraversal(curr.left, postorder);
        postorderTraversal(curr.right, postorder);
        postorder.add(curr.value);
    }

    public static void inorderTraversal(Node curr, ArrayList<Integer> inorder){
        if(curr == null){
            return;
        }

        inorderTraversal(curr.left, inorder);
        inorder.add(curr.value);
        inorderTraversal(curr.right, inorder);
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

        ArrayList < Integer > preOrder = new ArrayList < > ();
        preorderTraversal(root, preOrder);

        System.out.print("The preOrder Traversal is : ");
        for (int i = 0; i < preOrder.size(); i++) {
            System.out.print(preOrder.get(i) + " ");
        }
    }
}

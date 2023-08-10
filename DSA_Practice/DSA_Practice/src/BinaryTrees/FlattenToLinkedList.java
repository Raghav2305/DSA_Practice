package BinaryTrees;

import java.util.LinkedList;
import java.util.Stack;

public class FlattenToLinkedList {
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node() {

        }
    }

    static Node prev = null;
    public static void flattenUsingLinkedList(Node root){
        if(root == null) return;

        flattenUsingLinkedList(root.right);
        flattenUsingLinkedList(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void flattenUsingStack(Node root, Stack<Node> stack){
        if(root == null) return ;
        stack.push(root);
        while(!stack.isEmpty()){
            Node current = stack.pop();

            if(current.right != null){
                stack.push(current.right);
            }if(current.left != null){
                stack.push(current.left);
            }

            if(!stack.isEmpty()){
                current.right = stack.peek();
            }
            current.left = null;
        }
    }

    public static void main(String[] args) {
        Node  root = new Node(1);
        root . left = new Node(2);
        root . left . left = new Node(3);
        root . left . right = new Node(4);
        root . right = new Node(5);
        root . right . right = new Node(6);
        root . right . right . left = new Node(7);

        Stack<Node> stack = new Stack<>();
        flattenUsingLinkedList(root);
        while(root.right!=null)
        {
            System.out.print(root.value+"->");
            root=root.right;
        }
        System.out.print(root.value);
    }
}

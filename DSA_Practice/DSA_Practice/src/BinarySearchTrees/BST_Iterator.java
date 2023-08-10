package BinarySearchTrees;


import java.util.Stack;

public class BST_Iterator {

    public  class Node {
        int val;
        Node left;
        Node right;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private Stack<Node> stack = new Stack<>();
    public BST_Iterator(Node root) {
        pushAll(root);
    }

    public int next() {
        Node temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    public void pushAll(Node root){
        for(; root!= null; stack.push(root), root = root.left);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}

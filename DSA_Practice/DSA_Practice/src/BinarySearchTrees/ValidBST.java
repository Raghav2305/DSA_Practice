package BinarySearchTrees;

public class ValidBST {
    public static class Node{
        Node left , right;
        int value;

        public Node(Node left, Node right, int value){
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Node(int value){
            this.value = value;
        }

        public Node(){

        }
    }

    public static boolean checkBST(Node root){
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValid(Node root, long minVal, long maxVal){
        if(root == null) return true;
        if(root.value >= maxVal || root.value <=minVal) return false;

        return isValid(root.left, minVal, root.value) && isValid(root.right, root.value, maxVal);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.right = new Node(7);
        root.left.left = new Node(5);
        root.right = new Node(12);
        root.right.right = new Node(14);
        root.right.left = new Node(11);

        boolean ans = checkBST(root);
        System.out.println(ans);
    }
}

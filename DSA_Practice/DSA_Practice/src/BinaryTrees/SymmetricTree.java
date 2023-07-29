package BinaryTrees;

public class SymmetricTree {
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

    public static boolean symmetric(Node root){
        if (root == null){
            return false;
        }
        return traversal(root.left, root.right);
    }

    public static boolean traversal(Node root1, Node root2){
        if(root1 == null || root2 == null){
            return root1 == root2;
        }
        if(root1.value != root2.value){
            return false;
        }
        return traversal(root1.left, root2.right) && traversal(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(2);
        root.right.left = new Node(4);
//        root.right.right = new Node(3);

        boolean res = symmetric(root);
        System.out.println(res);
    }
}

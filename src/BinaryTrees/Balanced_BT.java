package BinaryTrees;

public class Balanced_BT {
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

    public static boolean checkBalanced(Node root){
        return height(root) != -1;
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int l_height = height(root.left);
        if (l_height == -1) return -1;
        int r_height = height(root.right);
        if (r_height == -1) return -1;

        if (Math.abs(l_height - r_height) > 1)  return -1;
        return  1 + Math.max(l_height, r_height);

    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.right = new Node(7);
        root.right.left = new Node(15);
//        root.left.left.left = new Node(7);
//        root.left.left.right = new Node(6);

        boolean ans = checkBalanced(root);
        System.out.println(ans);
        
    }
}

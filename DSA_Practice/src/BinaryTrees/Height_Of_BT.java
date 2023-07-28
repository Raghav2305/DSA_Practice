package BinaryTrees;

public class Height_Of_BT {
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

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int l_height = height(root.left);
        int r_height = height(root.right);

        return  1 + Math.max(l_height, r_height);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.right = new Node(6);

        int ans = height(root);
        System.out.println(ans);

    }
}

package BinaryTrees;

public class ChildrenSum_Property {
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public Node(int data){
            this.data = data;
        }
    }

    public static void changeTree(Node root){
        reorder(root);
    }

    static void reorder(Node  root) {
        if (root == null) return;
        int child = 0;
        if (root . left!=null) {
            child += root . left . data;
        }
        if (root . right!=null) {
            child += root . right . data;
        }

        if (child < root . data) {
            if (root . left!=null) root . left . data = root . data;
            else if (root . right!=null) root . right . data = root . data;
        }

        reorder(root . left);
        reorder(root . right);

        int tot = 0;
        if (root . left!=null) tot += root . left . data;
        if (root . right!=null) tot += root . right . data;
        if (root . left!=null || root . right!=null) root . data = tot;
    }

    public static void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.right.right = new Node(30);
        root.right.left = new Node(1);
        root.left.right = new Node(5);
        root.left.left = new Node(3);

        changeTree(root);
        printInOrder(root);


    }
}

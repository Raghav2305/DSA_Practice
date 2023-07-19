package BinaryTrees;

public class Identical_Trees {
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

    public static boolean identical(Node root1, Node root2){
        if( root1 == null || root2 == null){
            return root1 == root2;
        }

        return (root1.value == root2.value) && identical(root1.left, root2.left) && identical(root1.right, root2.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(78);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(79);

        boolean res = identical(root1, root2);
        System.out.println(res);
    }
}

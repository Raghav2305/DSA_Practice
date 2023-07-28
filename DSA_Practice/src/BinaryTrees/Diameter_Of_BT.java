package BinaryTrees;

public class Diameter_Of_BT {


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

    public static int calcDiameter(Node root){
          int [] diameter = new int[1];
          height(root, diameter);
          return diameter[0];
    }

    public static int height(Node root, int[] maxi){
        if(root == null){
            return 0;
        }

        int l_height = height(root.left, maxi);
        int r_height = height(root.right, maxi);
        maxi[0] = Math.max(maxi[0], l_height + r_height);

        return  1 + Math.max(l_height, r_height);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.left.left.left = new Node(9);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);
        root.right.right.right.right = new Node(8);

        int res = calcDiameter(root);
        System.out.println(res);
    }
}

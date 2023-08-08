package BinarySearchTrees;

public class CeilOfBST {
    private static class Node{
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

    public static int ceil(Node root, int key){
        if(root == null) return -1;
        int ceil = -1;
        while (root != null){

            if(root.value == key){
                ceil = root.value;
                return ceil;
            }
            if(key > root.value) {
                root = root.right;
            }
            else {
                ceil = root.value;
                root = root.left;

            }

        }
        return ceil;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.right = new Node(9);
        root.left.left = new Node(5);
        root.right = new Node(12);
        root.right.right = new Node(14);
        root.right.left = new Node(11);

        int ans = ceil(root, 6);
        System.out.println(ans);
    }
}

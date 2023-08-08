package BinarySearchTrees;

public class SearchInBST {

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

    public static Node search(Node root, int val){
        while(root!= null && root.value != val){
            if(val < root.value){
                root = root.left;
            }
            if(val > root.value){
                root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.right = new Node(9);
        root.left.left = new Node(5);
        root.right = new Node(12);
        root.right.right = new Node(14);
        root.right.left = new Node(11);

        Node res = search(root, 5);
        System.out.println(res);
        System.out.println(res.value);

    }
}

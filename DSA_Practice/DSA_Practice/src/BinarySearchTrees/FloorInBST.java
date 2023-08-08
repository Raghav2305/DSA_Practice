package BinarySearchTrees;

public class FloorInBST {
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

    public static int floor(Node root, int key){
        if(root == null){
            return -1;
        }
        int floor = -1;
        while(root != null){
            if(root.value == key){
                floor = root.value;
                return floor;
            }

            if(key < root.value){
                root = root.left;
            }
            else{
                floor = root.value;
                root = root.right;
                
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.right = new Node(9);
        root.left.left = new Node(5);
        root.right = new Node(12);
        root.right.right = new Node(14);
        root.right.left = new Node(11);

        int ans = floor(root, 7);
        System.out.println(ans);
    }
}

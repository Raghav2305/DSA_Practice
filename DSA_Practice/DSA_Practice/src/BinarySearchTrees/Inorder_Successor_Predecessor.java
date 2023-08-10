package BinarySearchTrees;

public class Inorder_Successor_Predecessor {
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

    public static Node successor(Node root, Node key){
        Node successor = null;
        while(root != null){
            if(key.value >= root.value){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static Node predecessor(Node root, Node key){
        Node predecessor = null;
        while(root != null){
            if(key.value <= root.value){
                root = root.left;
            }else{
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {
        
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.right = new Node(9);
        root.left.left = new Node(5);
        root.right = new Node(12);
        root.right.right = new Node(14);
        root.right.left = new Node(11);

        Node node = successor(root, root.right.left);
        System.out.println(node.value);

    }
}

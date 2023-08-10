package BinaryTrees;

public class CountTotalNodes {
    private static class Node{
        int value;
        Node left, right;

        public Node(int value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Node(int value){
            this.value = value;
        }
    }

    public static int countNodes(Node root){
        if(root == null) return 0;
        int left_H = leftHeight(root);
        int right_H = rightHeight(root);
        if(left_H == right_H){
            return (2 << left_H) - 1;
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    public static int leftHeight(Node root){
        int count = 0;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }public static int rightHeight(Node root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(5);
        root.left.right.right = new Node(11);
        root.left.right.left = new Node(10);
        root.left.left = new Node(4);
        root.left.left.right = new Node(9);
        root.left.left.left = new Node(8);
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.right.left = new Node(6);

        int res = countNodes(root);
        System.out.println(res);
    }
}

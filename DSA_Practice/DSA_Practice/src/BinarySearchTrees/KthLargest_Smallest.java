package BinarySearchTrees;

public class KthLargest_Smallest {
    private static int count = 0;
    private static int result = 0;
    public static class Node{
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

    public static int KthSmallest(Node root, int k){
        if(root == null) return -1;
        SmallestTraverse(root, k);
        return result;
    }

    public static void SmallestTraverse(Node root, int k) {
        if(root == null) return ;

        SmallestTraverse(root.left, k);
        count ++;
        if(count == k){
            result = root.value;

        }
        SmallestTraverse(root.right, k);
    }

    public static int KthLargest(Node root, int k){
//        if(root == null) return -1;

        LargestTraverse(root, k);
        return result;
    }
    public static void LargestTraverse(Node root, int k) {
        if(root == null) return ;

        LargestTraverse(root.right, k);
        count ++;
        if(count == k){
            result = root.value;
            return;
        }
        LargestTraverse(root.left, k);
    }


    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(26);
        root.left.right = new Node(39);
        root.left.left = new Node(41);
        root.right = new Node(54);
        root.right.right = new Node(61);
        root.right.left = new Node(75);

        int ans = KthSmallest(root, 3);
        System.out.println(ans);
    }
}

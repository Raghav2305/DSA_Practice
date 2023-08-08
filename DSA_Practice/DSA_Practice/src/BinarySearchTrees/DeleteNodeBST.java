package BinarySearchTrees;

public class DeleteNodeBST {
    static final int COUNT = 10;
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

    static void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(Node root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    public static Node delete(Node root, int key){
        if(root == null) return null;
        if(root.value == key){
            return helper(root);
        }
        Node dummy = root;
        while(root != null){
            if(root.value > key){
                if(root.left != null && root.left.value == key){
                    root.left = helper(root.left);
                }else{
                    root = root.left;
                }
            }else{
                if(root.right != null && root.right.value == key){
                    root.right = helper(root.right);
                }else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public static Node helper(Node root){
        if(root.left == null) return root.right;
        else if(root.right == null) return root.left;

        Node rightChild = root.right;
        Node lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    public static Node findLastRight(Node root){
        if(root.right == null){
            return root;
        }
        return findLastRight(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left = new Node(2);

//        print2D(root);
        delete(root, 8);
        print2D(root);
    }
}

package BinarySearchTrees;

public class InsertNodeBST {
    static final int COUNT = 10;
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

    public static Node insertNode(Node root, int val){
        if(root == null) return new Node(val);
        Node curr = root;

        while(true){
            if(curr.value <= val){
                if(curr.right != null) curr = curr.right;
                else{
                    curr.right = new Node(val);
                    break;
                }
            }else{
                if(curr.left != null) curr = curr.left;
                else{
                    curr.left = new Node(val);
                    break;
                }
            }
        }
        return curr;
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

    public static void main(String[] args) {
        Node root = new Node(6);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left = new Node(2);

//        print2D(root);
        insertNode(root, 5);
        print2D(root);
    }


}

package BinarySearchTrees;

public class BSTFromPreorder {
    static final  int COUNT = 10;
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

    public static Node bstFromPreorder(int[] ARRAY){
        return bstFromPreorder(ARRAY, Integer.MAX_VALUE, new int[]{0});
    }

    public static Node bstFromPreorder(int[] arr, int bound, int[] i){
        if(i[0] == arr.length || arr[i[0]] > bound) return null;
        Node root = new Node(arr[i[0]++]);
        root.left = bstFromPreorder(arr, root.value, i);
        root.right = bstFromPreorder(arr, bound, i);
        return root;
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
        int[] preorder = {8,5,1,7,10,12};
        Node ans = bstFromPreorder(preorder);
        System.out.println(ans.value);

        print2D(ans);
    }
}

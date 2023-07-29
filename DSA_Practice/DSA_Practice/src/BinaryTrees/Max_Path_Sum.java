package BinaryTrees;

public class Max_Path_Sum {
    private static int sum = 0;
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

    public static int maxPath(Node root){
        int[] maxVal = new int[1];
        maxVal[0] = Integer.MIN_VALUE;
        pathSum(root, maxVal);
        return maxVal[0];
    }

    public static int pathSum(Node root, int[] mav_val){

        if(root == null){
            return 0;
        }

        int left_val = Math.max(0 ,pathSum(root.left, mav_val));
        int right_val = Math.max(0 ,pathSum(root.right, mav_val));
        mav_val[0] = Math.max(mav_val[0], left_val + right_val + root.value);

        return Math.max( left_val , right_val) + root.value;


    }

//    public static int pathSum(Node root){
//        if(root == null){
//            return 0;
//        }
//        int left = pathSum(root.left);
//        int right = pathSum(root.right);
//
//        return   Math.max(sum, left + right + root.value);
//
//    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
//        root.right.left.left = new Node(5);
        root.right.right = new Node(7);

        int res = maxPath(root);
        System.out.println(res);
    }
}

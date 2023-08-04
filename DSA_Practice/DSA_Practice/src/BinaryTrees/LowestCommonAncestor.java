package BinaryTrees;

public class LowestCommonAncestor {
    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Node(int value){
            this.value = value;
        }
    }

    public static Node lcs(Node p, Node q, Node root){
        if(root == null || root == p || root == q){
            return root;
        }

        Node left = lcs(p, q, root.left);
        Node right = lcs(p, q, root.right);

        if(left == null){
            return right;
        } else if (right == null) {
            return left;
        }else{
            return root;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(8);
        root.right.right = new Node(5);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);

        Node p = root.right.right.right = new Node(7);
        Node q = root.right.left.left = new Node(8);

        Node ans = lcs(p,q , root);
        System.out.println(ans.value);
    }
}

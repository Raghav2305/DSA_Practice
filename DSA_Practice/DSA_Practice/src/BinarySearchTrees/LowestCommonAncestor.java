package BinarySearchTrees;

public class LowestCommonAncestor {
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

    public static Node FindLCA(Node root, Node p, Node q){
        if(root == null) return  null;
        int curr = root.value;

        if(curr < p.value && curr < q.value){
            return FindLCA(root.right, p, q);
        }
        else if (curr > p.value && curr > q.value){
             return FindLCA(root.left, p, q);
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

        Node p = root.left.left;
        Node q = root.left.right;
        Node ans = FindLCA(root, p,q );
        System.out.println(ans.value);
    }
}

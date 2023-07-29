package BinaryTrees;


import java.util.ArrayList;

public class RootToNodePath {
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

    public static ArrayList<Integer> solve(Node root, int num){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        path(root, ans, num);
        return ans;
    }

    public static boolean path(Node root, ArrayList<Integer> ans, int num){
        if(root == null) return false;
        ans.add(root.value);

        if(root.value == num) return true;
        if(path(root.left, ans, num) || path(root.right, ans, num)){
            return true;
        }

        ans.remove(ans.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);

        int num = 4;
        ArrayList<Integer> res = solve(root, num);
        System.out.print(res);
    }
}

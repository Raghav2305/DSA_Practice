package BinaryTrees;

import java.util.*;

public class BottomView {
    private static class Node {
        int value;
        Node left;
        Node right;
        int line = 0;

        public Node(int value, Node left, Node right, int line) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.line = line;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node() {

        }
    }

    public static ArrayList<Integer> bottom(Node root){
        ArrayList<Integer> ans  = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.line = 0;
        while(!queue.isEmpty()){
            Node ele = queue.remove();
            int line = ele.line;


            map.put(line, ele.value);


            if(ele.left != null){
                ele.left.line = line - 1;
                queue.add(ele.left);
            }
            if(ele.right != null){
                ele.right.line = line + 1;
                queue.add(ele.right);
            }
        }


        ans.addAll(map.values());
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> res = bottom(root);
        for (int i:res){
            System.out.print(i);
        }
    }

}
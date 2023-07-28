package BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;


public class TopView {
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

    public static ArrayList<Integer> top(Node root){
        ArrayList<Integer> ans  = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer, Integer> map = new HashMap<>();
//        Queue<Pair> queue = new Queue<Pair>() {
//
//        }
        return ans;
    }

}

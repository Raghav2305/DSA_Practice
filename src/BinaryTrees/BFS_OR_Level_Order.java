package BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_OR_Level_Order {
    private static class Node{
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

        public Node(){

        }
    }

    public static List<List<Integer>> BFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wrap = new LinkedList<>();

        if(root == null){
            return wrap;
        }

        queue.offer(root);
        while (!queue.isEmpty()){
            int q_size = queue.size();
            List<Integer> sublist = new LinkedList<>();
            for (int i = 0; i < q_size; i++) {
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                sublist.add(queue.poll().value);
            }
            wrap.add(sublist);
        }
        return wrap;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> result = BFS(root);

        for (List<Integer> list: result
             ) {
            for (int num: list
                 ) {
                System.out.print(num + "\t");

            }

        }
//        for (int i = 0; i < result.size(); i++) {
//            System.out.print(result.get(i));
//        }
    }
}

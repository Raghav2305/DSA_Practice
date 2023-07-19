package BinaryTrees;

import java.util.*;

public class ZigZag_Traversal {
    public static class Node{
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
        public Node(){
            
        }
    }
    
    public static List<List<Integer>> zigzag(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wrapper = new LinkedList<>();
        boolean flag = true;
        
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sublist = new LinkedList<>();
            for (int i=0; i < size; i++){
//                Node ele = queue.poll();
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                sublist.add(queue.poll().value);
            }
            if(flag){
                wrapper.add(sublist);
            }else{
                Collections.reverse(sublist);
                wrapper.add(sublist);
            }
            flag = !flag;

        }
        return wrapper;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        List<List<Integer>> res = zigzag(root);
        for (List<Integer> li: res
             ) {
            System.out.println(li);
        }

    }
}

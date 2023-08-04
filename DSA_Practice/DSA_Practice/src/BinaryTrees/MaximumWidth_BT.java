//REVISE THIS AGAIN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

package BinaryTrees;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth_BT {
    private static int ans;
    static class Pair{
        Node node;
        int index;
        public Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    private static class Node{
        int value;
        Node left;
        Node right;
        int index;

        public Node(int value, Node left, Node right, int index) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.index = index;
        }
        public Node(int value){
            this.value = value;
        }
    }

    public static int maxWidth(Node root){
        int ans = 0;
        if(root == null){
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()){
            int size = queue.size();
            int min_idx = queue.peek().index;
//            Pair pair = queue.remove();
//            Node ele = pair.node;
//            int index = pair.index;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int curr_id = queue.peek().index - min_idx;
                Node node = queue.peek().node;
                queue.poll();
                if(i == 0) first = curr_id;
                if(i == size -1) last = curr_id;
                if(node.left != null){
                    queue.offer(new Pair(node.left, (2*curr_id) +1));
                }
                if(node.right != null){
                    queue.offer(new Pair(node.right, (2*curr_id) +2));
                }
            }
            ans = Math.max(ans, last - first + 1);

        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(5);
        root.left.left.left = new Node(7);
        root.right =  new Node(2);
        root.right.right =  new Node(4);
        root.right.right.right =  new Node(6);
        
        int ans = maxWidth(root);
        System.out.println(ans);
    }
}

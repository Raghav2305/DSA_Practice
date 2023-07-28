package com.company;

import java.util.*;

public class Top_view_BT {
    NodeTree node;
    int v_line;

    public Top_view_BT(NodeTree node, int v_line) {
        this.node = node;
        this.v_line = v_line;
    }
}

class NodeTree{
    int val;
    NodeTree right;
    NodeTree left;

    public NodeTree(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public static ArrayList<Integer> top_view(NodeTree root){
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Queue<Top_view_BT> q = new LinkedList<Top_view_BT>();

        if (root == null){
            return ans;
        }

        q.offer(new Top_view_BT(root, 0));
        while (!q.isEmpty()){
            Top_view_BT pair = q.remove();
            int vertical = pair.v_line;
            NodeTree node = pair.node;

            if(map.get(vertical) ==null){
                map.put(vertical, node.val);
            if(node.left != null){
                q.add(new Top_view_BT(node.left, vertical -1));
            }
            if(node.right != null){
                q.add(new Top_view_BT(node.right, vertical +1));
            }

            }


        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        NodeTree root = new NodeTree(1);
        root.left = new NodeTree(2);
        root.right = new NodeTree(3);
        root.left.left = new NodeTree(4);
        root.left.right = new NodeTree(5);
        root.left.right.left = new NodeTree(6);
        root.right.right = new NodeTree(7);

        ArrayList<Integer> ans = top_view(root);

        for (int num: ans
             ) {
            System.out.println(ans.get(num));
        }
    }
}

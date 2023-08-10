package BinarySearchTrees;

import java.util.Stack;

public class BST_TWOSum {

    private class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
    class BST_Iterator{
        private Stack<BST_TWOSum.TreeNode> stack = new Stack<>();
        boolean reverse = true;

        public BST_Iterator(BST_TWOSum.TreeNode root, boolean isReverse){
            reverse = isReverse;
            pushAll(root);
        }

        public boolean hasNext(){
            return !stack.isEmpty();
        }

        public int next(){
            BST_TWOSum.TreeNode temp = stack.pop();
            if(!reverse) pushAll(temp.right);
            else pushAll(temp.left);
            return temp.val;
        }

        public void pushAll(BST_TWOSum.TreeNode root){
            while(root != null){
                stack.push(root);
                if (reverse){
                    root = root.right;
                }else{
                    root = root.left;
                }
            }
        }
    }

    class Solution{
        public boolean findTarget(BST_TWOSum.TreeNode root, int k){
            if(root == null) return false;

            BST_Iterator l = new BST_Iterator(root, false);
            BST_Iterator r = new BST_Iterator(root, true);

            int i = l.next();
            int j = r.next();
            while(i < j){
                if((i + j) == k){
                    return true;
                }else if(i + j < k){
                    i = l.next();
                }else{
                    j = r.next();
                }
            }
            return  false;
        }
    }
}

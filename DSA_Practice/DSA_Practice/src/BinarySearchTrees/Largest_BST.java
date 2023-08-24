package BinarySearchTrees;

public class Largest_BST {
    private static class TreeNode{
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

    class NodeValue{
        public int maxNode, minNode, maxSize;
        NodeValue(int maxNode, int minNode, int maxSize){
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }

    class Solution{
        private NodeValue binarySearchTreeHelper(TreeNode root){
            if(root == null){
                return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
            }
            NodeValue left = binarySearchTreeHelper(root.left);
            NodeValue right = binarySearchTreeHelper(root.right);

            if( left.maxNode < root.val && root.val < right.minNode){
                return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val,  right.maxNode), left.maxSize + right.maxSize + 1);
            }
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize,  right.maxSize));
        }
        public int largestBST(TreeNode root){
            return binarySearchTreeHelper(root).maxSize;
        }
    }


}

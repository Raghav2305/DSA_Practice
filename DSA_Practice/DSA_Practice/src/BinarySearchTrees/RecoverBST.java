package BinarySearchTrees;
public class RecoverBST {
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

    private TreeNode first, middle, previous, last;
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);

        if(first == null){
            first = previous;
            middle = root;
        }else{
            last = root;
        }

        previous = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root){
        first = last = middle = null;
        previous = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if(first!= null && last != null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else if(first!= null && middle!= null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}

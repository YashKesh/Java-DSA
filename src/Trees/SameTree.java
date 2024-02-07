package Trees;

public class SameTree {
    public static void main(String[] args) {
        SameTree sol = new SameTree();
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
//    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null && q==null){
                return true;
            }
            if(p.val!=q.val){
                return false;
            }
            boolean left= false;
            if(p.left!=null && q.left!=null){
                left = isSameTree(p.left,q.left);
            }

            boolean right = isSameTree(p.right,q.right);
            return left && right;
        }

}

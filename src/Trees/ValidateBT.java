package Trees;

public class ValidateBT {
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
        public boolean check(TreeNode root,long lower,long upper){
            if(root==null){
                return true;
            }
            if(root.val<=lower || root.val>=upper){
                return false;
            }
            boolean right  = true;
            if(root.right!=null){
                right = check(root.right,root.val,upper);
            }
            boolean left =true;
            if(root.left!=null){
                left =  check(root.left,lower,root.val);
            }
            return right && left;
        }
        public boolean isValidBST(TreeNode root) {
            if(root==null){
                return false;
            }
            return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
//        }
    }
}

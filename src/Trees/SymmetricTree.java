package Trees;
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
public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree sol = new SymmetricTree();
    }
//    class Solution {
        public boolean solve(TreeNode p,TreeNode q){
            if(p==null && q==null){
                return true;
            }
            if(p==null || q==null){
                return false;
            }
            if(p.val!=q.val){
                return false;
            }
            boolean left = solve(p.right,q.left);
            boolean right = solve(p.left,q.right);
            return left && right;
        }
        public boolean isSymmetric(TreeNode root) {
            return solve(root.left,root.right);
        }
//    }
}

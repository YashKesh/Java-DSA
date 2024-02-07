package Trees;

public class InvertTree {
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
    public static void main(String[] args) {
        InvertTree sol = new InvertTree();
    }
//    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root==null){
                return root;
            }
            TreeNode temp  = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(temp);
            return root;
        }
    }
//}

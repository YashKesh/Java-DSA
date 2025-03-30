package Trees;
/*
    * Given the root of a binary tree, invert the tree, and return its root.
    * Example:
    * Input: root = [4,2,7,1,3,6,9]
    * Output: [4,7,2,9,6,3,1]
 */
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

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode ans = sol.invertTree(root);
        System.out.println(ans.val);
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

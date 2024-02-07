package Trees;
import java.util.*;
public class RightView {
    public static void main(String[] args) {
        RightView sol = new RightView();
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
        int maxlevel = 0;
        List<Integer> res = new ArrayList<>();
        public void solve(TreeNode root,int depth){
            if(root==null){
                return;
            }
            if(maxlevel<depth){
                res.add(root.val);
                maxlevel = depth;
            }
            solve(root.right,depth+1);
            solve(root.left,depth+1);

        }
        public List<Integer> rightSideView(TreeNode root) {

            if(root==null){
                return res;
            }
            solve(root,1);
            return res;
        }
    }
//}

package Trees;
import java.util.*;
public class LevelorderLeaftoParent {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();
            if(root==null){
                return res;
            }
            Queue<TreeNode> q = new LinkedList<>();
            Stack<List<Integer>> stack = new Stack<>();
            q.add(root);
            while(!q.isEmpty()){
                int length = q.size();
                List<Integer> list1 = new ArrayList<>();
                for(int i = 0;i<length;i++){
                    TreeNode node = q.poll();
                    list1.add(node.val);
                    if(node.left!=null){
                        q.add(node.left);
                    }
                    if(node.right!=null){
                        q.add(node.right);
                    }
                }
                stack.add(list1);
                // res.add(list1);
            }
            while(!stack.isEmpty()){
                res.add(stack.pop());
            }
            // Collections.reverse(res);
            return res;
        }
    }
//}

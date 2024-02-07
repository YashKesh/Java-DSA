package Trees;
import java.util.*;
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
public class LevelOrderTraversal {

//    class Solution {
        List<List<Integer>> mylist = new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue= new LinkedList<>();
            if(root==null){
                return mylist;
            }
            queue.add(root);
            while(!queue.isEmpty()){
                int length = queue.size();
                List<Integer> newlist = new ArrayList<>();
                for(int i = 0;i<length;i++){
                    TreeNode node = queue.poll();
                    newlist.add(node.val);
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }
                }
                mylist.add(newlist);
            }
            return mylist;
        }
    }
//}

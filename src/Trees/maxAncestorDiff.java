package Trees;
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
public class maxAncestorDiff {
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
        public int maxAncestorDiff(TreeNode root) {
            Pair p = new Pair(0,0);
            dfs(root,p);
            return p.first;
        }
        public Pair dfs(TreeNode root,Pair p){
            if(root==null){
                return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE);
            }
            Pair left = dfs(root.left,p);
            Pair right = dfs(root.right,p);
            int maxval = Math.max(root.val,Math.max(left.second,right.second));
            int minval = Math.min(root.val,Math.min(left.first,right.first));
            p.first = Math.max(p.first,Math.max(Math.abs(root.val-minval),Math.abs(root.val-maxval)));
            return new Pair(minval,maxval);
        }
    }


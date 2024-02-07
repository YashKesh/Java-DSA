package Trees;
import java.util.*;
public class MinDepth {
    public static void main(String[] args) {
        MinDepth sol = new MinDepth();
    }
    public int minDepth(TreeNode root) {
        // int length =0;
        // if(root==null){
        //     return 0;
        // }
        // return dfs(root,length);
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            count++;
            while (len > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return count;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
        }
        return count;
    }
}

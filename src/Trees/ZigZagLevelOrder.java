package Trees;
import java.util.*;
public class ZigZagLevelOrder {
    public static void main(String[] args) {
        ZigZagLevelOrder sol = new ZigZagLevelOrder();
    }
//    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            List<List<Integer>> mylist = new ArrayList<>();
            if(root==null){
                return mylist;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i = 1;
            while(!queue.isEmpty()){
                int length = queue.size();
                List<Integer> newlist = new ArrayList<>();
                for(int j = 0;j<length;j++){
                    TreeNode node = queue.poll();
                    newlist.add(node.val);
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }
                }
                if(i%2==0){
                    Collections.reverse(newlist);
                }
                i++;
                mylist.add(newlist);
            }
            return mylist;
        }
    }
//}

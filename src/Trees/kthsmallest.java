package Trees;

//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

public class kthsmallest {

    public static void main(String[] args) {
        kthsmallest sol = new kthsmallest();
    }
//    class Solution {

        List<Integer> list=new ArrayList<>();
        public int kthSmallest(TreeNode root, int k) {
            if(root==null)return 0;
            help(root,k);
            return list.get(k-1);
        }
        public void help(TreeNode root,int k)
        {
            if(root==null)return;
            help(root.left,k);
            list.add(root.val);
            if(list.size()==k)return;
            help(root.right,k);
        }
    public int kthSmallest1(TreeNode root, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode node = q.poll();
                minheap.add(node.val);
                while(minheap.size()>k){
                    minheap.poll();
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }
        return minheap.poll();
    }
    }
//}

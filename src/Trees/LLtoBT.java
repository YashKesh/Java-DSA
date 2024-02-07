package Trees;

import LinkedList.ListNode;

//import javax.swing.tree.TreeNode;

public class LLtoBT {
        public static void main(String[] args) {
        LLtoBT sol = new LLtoBT();
        }

        private ListNode node;
        public TreeNode sortedListToBST(ListNode head) {
            ListNode temp = head;
            node = head;
            int size = 0;
            while(temp!=null){
                temp = temp.next;
                size++;
            }
            return BT(0,size-1);
        }
        public  TreeNode BT(int start,int end){
            if(start>end){
                return null;
            }
            int mid = start + (end-start)/2;

            TreeNode left = BT(start,mid-1);

            TreeNode root = new TreeNode(node.val);
            root.left = left;
            node = node.next;

            TreeNode right = BT(mid+1,end);

            root.right = right;
            return root;

        }

}

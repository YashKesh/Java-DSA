package Trees;
//import LinkedList;
import LinkedList.ListNode;

public class SortedListtoBT {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
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
//}

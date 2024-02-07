package LinkedList;

public class ReorderList {
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
    public static void main(String[] args) {
        ReorderList sol = new ReorderList();
    }
        public ListNode reverse(ListNode head){
            ListNode current = head ,next = head;
            ListNode prev = null;
            while(current!= null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }

        public ListNode middle(ListNode head){
            ListNode fast =head ,slow = head;
            while(fast!=null && fast.next!=null ){
                fast = fast.next.next;
                slow= slow.next;
            }
            return slow;
        }
        public void reorderList(ListNode head) {
            if(head==null || head.next==null){
                return;
            }

            ListNode mid = middle(head);
            ListNode rev = reverse(mid);
            ListNode sample = head;
            while(sample!=null && rev!=null ){
                ListNode node = sample.next;  //node = 2
                sample.next = rev;            //1->5
                sample = node;                //sample 2
                node = rev.next;               // node = 4
                rev.next = sample;              // 5->2
                rev = node;                     //rev = 4
            }
            if(sample!=null){
                sample.next = null;
            }
        }

}

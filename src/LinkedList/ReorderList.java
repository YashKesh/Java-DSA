package LinkedList;
/*
    * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    * You may not modify the values in the list's nodes, only nodes itself may be changed.
    * Example:
    * Given 1->2->3->4, reorder it to 1->4->2->3.
 */
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        sol.reorderList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
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

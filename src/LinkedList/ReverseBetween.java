package LinkedList;
/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseBetween {
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
        ReverseBetween sol  = new ReverseBetween();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode ans = sol.reverseBetween(head,2,4);
        while(ans!=null){
            System.out.print(ans.val+" ");
            ans = ans.next;
        }

    }
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left==right){
                return head;
            }
            ListNode current = head;
            ListNode prev = null;
            for(int i = 0; current!=null && i<left-1;i++){
                prev = current;
                current = current.next;
            }
            ListNode last = prev;
            ListNode newend = current;
            ListNode next = current.next;
            for(int i = 0;current!=null && i<right-left+1;i++){
                current.next = prev;
                prev = current;
                current = next;
                if(next!=null){
                    next = next.next;
                }
            }
            if(last!=null){
                last.next = prev;
            }
            else{
                head = prev;
            }
            newend.next = current;
            return head;

        }

}

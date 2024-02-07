package LinkedList;

public class ReverseKgroup {
    public static void main(String[] args) {
        ReverseKgroup sol = new ReverseKgroup();
    }
     public static int length(ListNode head){
         int length = 0;
         while(head!=null){
             head = head.next;
             length++;
         }
         return length;
     }
     public ListNode reverseK1stGroup(ListNode head, int k) {
         if(k<=1 || head==null){
             return head;
         }
         ListNode current = head;
         ListNode prev = null;
         int length = length(head);
         int count = length/k;
         while(count>0){
             ListNode last = prev;
             ListNode newend = current;
             ListNode next = current.next;
             for(int i  = 0;i<k && current!=null;i++){
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
             prev = newend;
             count--;

         }
         return head;

         }
// }
//    public class Solution {
        public ListNode reverseK2ndGroup(ListNode head, int k) {
            if (head == null || k == 1)
                return head;

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode begin = dummy;
            int i = 0;

            while (head != null) {
                i++;
                if (i % k == 0) {
                    begin = reverse(begin, head.next);
                    head = begin.next;
                } else {
                    head = head.next;
                }
            }
            return dummy.next;
        }

        private ListNode reverse(ListNode begin, ListNode end) {
            ListNode curr = begin.next;
            ListNode prev = begin;
            ListNode first = curr;  // To remember the first node for connecting to the rest of the list
            while (curr != end) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            begin.next = prev;
            first.next = curr;  // Reconnecting the reversed list to the main list
            return first;  // Returning the last node in reversed section to be the beginning of next reversal
        }
    }
//}

package LinkedList;
/*
    * From a given linked list, remove all the duplicates such that each element appear only once.
    * The linked list is represented by a Node class:
    * class Node {
    *     int val;
    *     Node next;
    *     Node(int x) { val = x; }
    * }
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        DeleteDuplicates sol = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        System.out.println(sol.deleteDuplicates(head));
        // Expected: 1->2->3->4->5

    }
        public ListNode deleteDuplicates(ListNode head) {
            ListNode temp = new ListNode(0);
            temp.next = head;
            ListNode prev = temp;
            while(head!=null && head.next!=null){
                if(head.val==head.next.val){
                    while(head!=null && head.next!=null && head.val == head.next.val){
                        head = head.next;
                    }
                    head = head.next;
                    prev.next = head;
                }
                else{
                    prev = prev.next;
                    head = head.next;
                }

            }
            return temp.next;
        }
    }


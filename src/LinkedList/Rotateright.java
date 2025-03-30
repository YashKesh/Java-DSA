package LinkedList;
/*
    * Given a linked list, rotate the list to the right by k places, where k is non-negative.
    * Example:
    * Input: 1->2->3->4->5->NULL, k = 2
    * Output: 4->5->1->2->3->NULL
 */
public class Rotateright {
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

    }
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            ListNode cur = head;
            int length = 1;
            while (cur.next != null) {
                cur = cur.next;
                length++;
            }
            // System.out.print(length);
            cur.next = head;
            k = length - (k % length);
            while (k > 0) {
                cur = cur.next;
                k--;
            }

            ListNode newHead = cur.next;
            cur.next = null;
            return newHead;

        }
    }


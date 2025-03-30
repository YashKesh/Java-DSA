package LinkedList;

// Definition for singly-linked list.
/*
    * Given two sorted linked lists, merge them into a single sorted linked list.
    * The merged linked list should also be sorted.
 */

public class MergetwosortLL {
    public static void main(String[] args) {
        MergetwosortLL sol = new MergetwosortLL();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode mergedList = sol.mergeTwoLists(l1, l2);
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }

//        ListNode ans = sol.mergeTwoLists()
    }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode cur = head;
            while(list1!=null && list2!=null){
                if(list1.val<=list2.val){
                    cur.next = list1;
                    list1 = list1.next;
                }
                else{
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            if(list1==null){
                cur.next = list2;
            }
            else if (list2==null){
                cur.next = list1;
            }
            return head.next;


        }
    }

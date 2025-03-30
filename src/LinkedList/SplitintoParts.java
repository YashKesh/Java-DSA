package LinkedList;
/*
    * Given a singly linked list, split it into k consecutive linked list parts.
    * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1.
    * This may lead to some parts being null.
    * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size 
    greater than or equal to parts occurring later.
    * Return an array of the k parts.
 */
public class SplitintoParts {
    public static void main(String[] args) {
        SplitintoParts sol = new SplitintoParts();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode[] res = sol.splitListToParts(head, 3);
        for (ListNode node : res) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }
        
    }
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode cur = root;
            int N = 0;
            while (cur != null) {
                cur = cur.next;
                N++;
            }

            int width = N / k, rem = N % k;

            ListNode[] ans = new ListNode[k];
            cur = root;
            for (int i = 0; i < k; ++i) {
                ListNode head = new ListNode(0), write = head;
                for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                    write = write.next = new ListNode(cur.val);
                    if (cur != null) cur = cur.next;
                }
                ans[i] = head.next;
            }
            return ans;
        }
    }


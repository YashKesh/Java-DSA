package LinkedList;

public class DeleteDuplicates {
    public static void main(String[] args) {
        DeleteDuplicates sol = new DeleteDuplicates();

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


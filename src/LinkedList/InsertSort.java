package LinkedList;
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
public class InsertSort {
    Node sortedInsert(Node head1, int key) {
        // Add your code here.
        Node x = new Node(key);                 // jb new node starting m insert krni ho
        if(head1.data>=key){
            x.next = head1;
            return x;
        }

        Node node = head1;                  // jb new node do nodes ke beech m insert krni ho
        while(node.next!=null){
            if(node.data<key && node.next.data>=key){
                x.next = node.next;
                node.next = x;
                return head1;
            }
            node = node.next;
        }
        node.next = x;                            // jb new node last m insert krni ho

        return head1;
    }
}

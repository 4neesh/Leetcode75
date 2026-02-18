import util.ListNode;

public class J_32_ReverseLinkedList {


    public static void main(String[] args) {


    }

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode current = head;
        ListNode previous = null;

        while(current != null){
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return current;
    }
}
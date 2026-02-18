import util.ListNode;

public class J_31_OddEvenLinkedList {

    public static void main(String[] args) {



    }

    public ListNode oddEvenList(ListNode head) {

        ListNode odd = head;
        ListNode even = null;
        ListNode evenHead = null;

        if(head == null || head.next == null){
            return head;
        }
        evenHead = even = head.next;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }


}
public class J_32_ReverseLinkedList {


    public static void main(String[] args) {


    }

    public ListNode3 reverseList(ListNode3 head) {

        if(head == null || head.next == null) return head;

        ListNode3 current = head;
        ListNode3 previous = null;

        while(current != null){
            ListNode3 nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return current;
    }
}

class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
}
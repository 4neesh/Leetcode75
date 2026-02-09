public class J_31_OddEvenLinkedList {

    public static void main(String[] args) {



    }

    public ListNode2 oddEvenList(ListNode2 head) {

        ListNode2 odd = head;
        ListNode2 even = null;
        ListNode2 evenHead = null;

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

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}

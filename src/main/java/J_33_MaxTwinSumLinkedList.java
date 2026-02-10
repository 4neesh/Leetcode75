public class J_33_MaxTwinSumLinkedList {

    public static void main(String[] args) {

        ListNode4 head = new ListNode4(5);
        ListNode4 a = new ListNode4(4);
        ListNode4 b = new ListNode4(2);
        ListNode4 c = new ListNode4(1);
        head.next = a;
        a.next = b;
        b.next = c;
        pairSum(head);
    }
    public static int pairSum(ListNode4 head) {

        ListNode4 slow = head;
        ListNode4 fast = head;
        ListNode4 prev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            //the next value of slow is stored

            //slow becomes the next value
            //slow points to the previous value
            ListNode4 next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;

        }

        int result = 0;
        while(slow != null && prev != null){
            int res = slow.val + prev.val;
            result = Math.max(res, result);
            slow = slow.next;
            prev = prev.next;
        }

        return result;
    }


}


class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4() {}
    ListNode4(int val) { this.val = val; }
    ListNode4(int val, ListNode4 next) { this.val = val; this.next = next; }
}
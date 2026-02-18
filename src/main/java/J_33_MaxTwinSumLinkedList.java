import util.ListNode;

public class J_33_MaxTwinSumLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        head.next = a;
        a.next = b;
        b.next = c;
        pairSum(head);
    }

    public static int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            //the next value of slow is stored

            //slow becomes the next value
            //slow points to the previous value
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;

        }

        int result = 0;
        while (slow != null && prev != null) {
            int res = slow.val + prev.val;
            result = Math.max(res, result);
            slow = slow.next;
            prev = prev.next;
        }

        return result;
    }


}
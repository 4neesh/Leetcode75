import util.ListNode;

public class J_30_DeleteMiddleNode {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next = new ListNode(4);
        head.next = new ListNode(7);
        head.next = new ListNode(1);
        head.next = new ListNode(2);
        head.next = new ListNode(6);

        head = deleteMiddle(head);
        System.out.println(head);

    }

    public static ListNode deleteMiddle(ListNode head){

        ListNode current = head;
        ListNode midPrev = null;
        ListNode middle = head;

        while (current.next != null){
            if(current.next.next != null) {
                current = current.next.next;
                midPrev = middle;
                middle = middle.next;
            }
            else{
                current = current.next;
                midPrev = middle;
                middle = middle.next;
            }
        }

        if(midPrev != null) {
            midPrev.next = middle.next;
        }
        else{
            return null;
        }

        return head;
    }

}




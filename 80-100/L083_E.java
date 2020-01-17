import basicDataStructure.ListNode;

public class L083_E {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;
        while (head != null) {
            ListNode tempNext = head.next;
            if (tempNext != null && tempNext.val == head.val) {
                head.next = tempNext.next;
            } else {
                head = head.next;
            }
        }
        return first;
    }
}

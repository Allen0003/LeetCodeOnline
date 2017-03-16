package practice;

/**
 * Given a linked list, determine if it has a cycle in it.
 */

public class LeetCode141_LinkedListCycle_E {

	public static void main(String[] args) {

		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode ListNode3 = new ListNode(3);
		ListNode ListNode4 = new ListNode(4);

		ListNode1.next = ListNode2;
		ListNode2.next = ListNode3;
		ListNode3.next = ListNode4;
		ListNode4.next = ListNode3;

		System.out.println(new LeetCode141_LinkedListCycle_E().hasCycle(ListNode1));

	}

	public boolean hasCycle(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;
		}

		return false;
	}

}

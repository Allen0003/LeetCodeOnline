package practice;

/**
 * problem description: Reverse a singly linked list.
 * 
 * prev --> cur --> next
 * 
 * node --> node --> node
 * 
 * cur.next = prev <br>
 * if (prev == head) <br>
 * prev = null <br>
 * 
 * prev <-- cur next <br>
 * 
 * node <-- node node
 * 
 * prev = cur<br>
 * cur = next <br>
 * next = next.next<br>
 * 
 */

 class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class LeetCode206_ReverseLinkedList_E {
	public ListNode reverseList(ListNode head) {

		// return directly when zero and zero cases happened
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = null;
		ListNode next = null;
		boolean isStop = false;

		prev = head;
		cur = prev.next;
		while (!isStop) {

			// should be handled next time
			if (cur.next != null) {
				next = cur.next;
			}

			cur.next = prev;
			if (prev == head) {
				prev.next = null;
			}
			// considering two nodes case
			if (next != null) {
				prev = cur;
				cur = next;
				if (next.next != null) {
					next = next.next;
				} else {
					cur.next = prev;
					isStop = true;
				}
			} else {
				isStop = true;
			}
		}
		return cur;
	}
}

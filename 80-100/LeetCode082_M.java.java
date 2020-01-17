package practice;

/**
 * problem description:
 * 
 * Given a sorted linked list, delete all nodes that have duplicate
 * numbers, </br>
 * leaving only distinct numbers from the original list.</br>
 * 
 * For example,</br>
 * Given 1->2->3->3->4->4->5, return 1->2->5.</br>
 * Given 1->1->1->2->3, return 2->3.</br>
 */

public class LeetCode082_RemoveDuplicatesFromSortedListII_M {
	public static void main(String[] args) {

		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(1);
		ListNode ListNode3 = new ListNode(1);
		// ListNode ListNode4 = new ListNode(3);
		// ListNode ListNode5 = new ListNode(6);
		// ListNode ListNode6 = new ListNode(3);
		// ListNode ListNode7 = new ListNode(4);

		// preNode = 3
		// preNode.next = 6
		// curNode = 7

		ListNode1.next = ListNode2;
		ListNode2.next = ListNode3;
		// ListNode3.next = ListNode4;
		// ListNode4.next = ListNode5;
		// ListNode5.next = ListNode6;
		// ListNode6.next = ListNode7;

		// ListNode head = new DeleteDuplicates_M().deleteDuplicates(ListNode1);
		ListNode head = new LeetCode082_RemoveDuplicatesFromSortedListII_M().deleteDuplicates_onlineSolution(ListNode1);
		new LeetCode082_RemoveDuplicatesFromSortedListII_M().displayVal(head);
	}

	/*
	 * Thinking point => 1.three different nodes 2. three different cases
	 * 
	 * case:
	 * 
	 * head => duplicated data happened in the head element
	 * 
	 * body => duplicated data happened in the body element
	 * 
	 * tail => duplicated data happened in the tail element
	 * 
	 * node:
	 * 
	 * preNode => recode the previous node for removing the body case and tail
	 * case
	 * 
	 * curNode => recode the beginning duplicated data
	 * 
	 * nextNode => recode the trace node
	 * 
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode preNode = head;
		ListNode curNode = head;
		ListNode nextNode = curNode.next;

		boolean isMove = false;
		while (nextNode != null) {
			while (nextNode != null && curNode.val == nextNode.val) {
				nextNode = nextNode.next;
				isMove = true;
			}
			// no need to move when duplicated data happened in the last
			// elements
			if (nextNode != null) {
				// duplicated data happened in the first elements
				if (isMove && head.val == curNode.val) {
					head = nextNode;
					preNode = head;
					curNode = head;
					nextNode = curNode.next;
				}
				// duplicated data happened in the body elements
				else if (isMove) {
					while (preNode.next != null && preNode.next.val != curNode.val) {
						preNode = preNode.next;
					}
					preNode.next = nextNode;
					curNode = nextNode;
					nextNode = curNode.next;
				} else {
					curNode = curNode.next;
					nextNode = nextNode.next;
				}
				isMove = false;
			}
		}

		// duplicated data happened in the last elements
		if (curNode.next != null) {
			while (preNode.next.val != curNode.val) {
				preNode = preNode.next;
			}
			preNode.next = null;
		}
		// only one element case
		if (preNode.val == head.val && curNode.val == head.val && isMove) {
			head = null;
		}
		return head;
	}

	// using one more node called dummy for keeping while stable
	public ListNode deleteDuplicates_onlineSolution(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		while (head.next != null && head.next.next != null) {
			// get next and next.next at once
			if (head.next.val == head.next.next.val) {
				int val = head.next.val;
				while (head.next != null && head.next.val == val) {
					head.next = head.next.next;
				}
			} else {
				head = head.next;
			}
		}

		return dummy.next;
	}

	public void displayVal(ListNode head) {
		System.out.println("==========final============");
		while (head.next != null) {
			System.out.print(" node = " + head.val);
			head = head.next;
		}
		System.out.print(" node = " + head.val);
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
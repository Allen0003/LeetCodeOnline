/**
problem description:
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

*/

/**
 * first step: cutting the main linked list to two linked lists.</br>
 * One is called 'A' and the another one is called 'B'</br>
 * second step: reverse A in order to do next step </br>
 * third step: recreate a new linked list by get and travel each node
 * respectively
 * 
 */
public class ReorderList_M {

	public static void main(String[] args) {

		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode ListNode3 = new ListNode(3);
		ListNode ListNode4 = new ListNode(4);
		ListNode ListNode5 = new ListNode(5);
		ListNode ListNode6 = new ListNode(6);
		// ListNode ListNode7 = new ListNode(7);

		ListNode1.next = ListNode2;
		// ListNode2.next = ListNode3;
		// ListNode3.next = ListNode4;
		// ListNode4.next = ListNode5;
		// ListNode5.next = ListNode6;
		// ListNode6.next = ListNode7;
		new ReorderList_M().reorderList(ListNode1);
	}

	public void reorderList(ListNode head) {

		if (head == null) {
			return;
		}

		int linkLength = getLength(head);

		if (linkLength < 3) {
			return;
		}

		// finding the middle point
		int cuttingPoint = 0;
		ListNode travelNode = head;

		cuttingPoint = ((int) Math.floor(((float) linkLength / 2)));
		// cuttingPoint cutting starts form this point

		ListNode secondHead = null;
		while (travelNode.next != null) {
			if (cuttingPoint != 0) {
				cuttingPoint--;
			} else if (secondHead == null) {
				secondHead = new ListNode(travelNode.val);
				secondHead.next = travelNode.next;
				break;
			}
			travelNode = travelNode.next;
		}
		travelNode.next = null;
		secondHead = reverseList(secondHead);
		travelNode = head;
		ListNode tempTravel = new ListNode(0);

		int count = 0; // decide what is the next action
		while (linkLength != count) {
			if (count % 2 == 0) {
				tempTravel.next = travelNode;
				travelNode = travelNode.next;
			} else if (count % 2 == 1) {
				tempTravel.next = secondHead;
				secondHead = secondHead.next;
			}
			tempTravel = tempTravel.next;
			count++;
		}
		ListNode.displayVal(head);
	}

	public int getLength(ListNode head) {
		ListNode temp = head;
		int result = 0;
		while (temp != null) {
			result++;
			temp = temp.next;
		}
		return result;
	}

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

			// should be handled node next time
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
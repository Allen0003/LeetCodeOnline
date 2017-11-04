package practice;

import java.util.HashMap;

public class L002_M {

	public static void main(String[] args) {
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(5);
		System.out.println(new L002_M().addTwoNumbers(a, b));
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result1 = null;

		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();

		int digital = 1;
		int shift = 0;
		while (l1 != null || l2 != null) {
			int l1Value = l1 == null ? 0 : l1.val;
			int l2Value = l2 == null ? 0 : l2.val;
			int curr = shift + l1Value + l2Value;
			shift = l1Value + l2Value + shift >= 10 ? 1 : 0;
			result.put(digital, curr % 10);
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			digital++;
		}
		if (shift != 0) {
			result.put(digital, shift);
			digital++;
		}
		result1 = new ListNode(result.get(1));
		ListNode last = result1;
		for (int i = 2; i < digital; i++) {
			addTwoNode(last, new ListNode(result.get(i)));
			last = last.next;
		}
		return result1;
	}

	public void addTwoNode(ListNode l1, ListNode l2) {
		l1.next = l2;
	}

}

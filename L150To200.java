import basicDataStructure.ListNode;

import java.util.Stack;

public class L150To200 {

    Stack<Integer> minStack = null;

    public L150To200() {
        this.minStack = new Stack();
    }

    public void push(int x) {
        this.minStack.push(x);
    }

    public void pop() {
        this.minStack.pop();
    }

    public int top() {
        Integer temp = this.minStack.pop();
        this.push(temp);
        return temp;
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;

        for (Integer temp : this.minStack) {
            min = Math.min(temp, min);
        }
        return min;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//        headA = this.reverseListNode(headA);
//        headB = this.reverseListNode(headB);

        while (headA.next != null) {

            headA = headA.next;
            System.out.println(headA.val);
        }


        return null;
    }


    public ListNode reverseListNode(ListNode curr) {

        ListNode pointer = curr;
        ListNode previous = null, current = null;

        while (pointer != null) {
            current = pointer;
            pointer = pointer.next;

            // reverse the link
            current.next = previous;
            previous = current;
            curr = current;
        }
        return curr;
    }


}

import basicDataStructure.ListNode;


import java.util.ArrayList;
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

        if (headA == null || headB == null) {
            return null;
        }

        ArrayList<ListNode> temp = new ArrayList<>();
        while (headA.next != null) {
            temp.add(headA);
            headA = headA.next;
        }
        temp.add(headA);

        while (headB.next != null) {
            if (temp.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        if (temp.contains(headB)) {
            return headB;
        }
        return null;
    }

    public String numberToCharacter(int n) {
        if (n == 1)
            return "A";
        if (n == 2)
            return "B";
        if (n == 3)
            return "C";
        if (n == 4)
            return "D";
        if (n == 5)
            return "E";
        if (n == 6)
            return "F";
        if (n == 7)
            return "G";
        if (n == 8)
            return "H";
        if (n == 9)
            return "I";
        if (n == 10)
            return "J";
        if (n == 11)
            return "K";
        if (n == 12)
            return "L";
        if (n == 13)
            return "M";
        if (n == 14)
            return "N";
        if (n == 15)
            return "O";
        if (n == 16)
            return "P";
        if (n == 17)
            return "Q";
        if (n == 18)
            return "R";
        if (n == 19)
            return "S";
        if (n == 20)
            return "T";
        if (n == 21)
            return "U";
        if (n == 22)
            return "V";
        if (n == 23)
            return "W";
        if (n == 24)
            return "X";
        if (n == 25)
            return "Y";
        if (n == 0)
            return "Z";

        return "";
    }

    public String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }
        String result = "";
        int divisor = 26;

        while (n > 0) {
            result = this.numberToCharacter(n % 26) + result;
            boolean isZ = false;
            if (n % 26 == 0) { //case Z
                isZ = true;
            }
            n = n / divisor;
            if (isZ) {
                n = n - 1;
            }
        }
        return result;
    }


}

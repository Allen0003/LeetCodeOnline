import basicDataStructure.ListNode;


import java.util.ArrayList;
import java.util.Arrays;
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


    public int numberToCharacter(String n) {
        if (n.equals("A"))
            return 1;
        if (n.equals("B"))
            return 2;
        if (n.equals("C"))
            return 3;
        if (n.equals("D"))
            return 4;
        if (n.equals("E"))
            return 5;
        if (n.equals("F"))
            return 6;
        if (n.equals("G"))
            return 7;
        if (n.equals("H"))
            return 8;
        if (n.equals("I"))
            return 9;
        if (n.equals("J"))
            return 10;
        if (n.equals("K"))
            return 11;
        if (n.equals("L"))
            return 12;
        if (n.equals("M"))
            return 13;
        if (n.equals("N"))
            return 14;
        if (n.equals("O"))
            return 15;
        if (n.equals("P"))
            return 16;
        if (n.equals("Q"))
            return 17;
        if (n.equals("R"))
            return 18;
        if (n.equals("S"))
            return 19;
        if (n.equals("T"))
            return 20;
        if (n.equals("U"))
            return 21;
        if (n.equals("V"))
            return 22;
        if (n.equals("W"))
            return 23;
        if (n.equals("X"))
            return 24;
        if (n.equals("Y"))
            return 25;
        if (n.equals("Z"))
            return 26;
        return 0;
    }

    public int titleToNumber(String s) {
        int result = 0;
        if (s.equals("")) {
            return result;
        }
        String target[] = s.split("");
        int digitalIndex = 0;
        for (int i = target.length - 1; i >= 0; i--) {
            result += this.numberToCharacter(target[i]) * (Math.pow(26, digitalIndex));
            digitalIndex = digitalIndex + 1;
        }
        return result;
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

    public int trailingZeroes(int n) {
        int countZero = 0;
        while (n != 0) {
            n = n / 5;
            countZero += n;
        }
        return countZero;
    }


    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        if (n > 2) {
            nums[n - 3] += nums[n - 1];
        }

        for (int i = n - 4; i >= 0; i--) {
            nums[i] += nums[i + 2] > nums[i + 3] ? nums[i + 2] : nums[i + 3];
        }

        return Math.max(nums[0], nums[1]);
    }

    public int hammingWeight(int n) {
        
        int count = 0;

        while (n > 1) {
            if (n % 2 == 1) {
                count = count + 1;
            }
            n = n / 2;
        }

        if (n % 2 == 1) {
            count = count + 1;
        }

        return count;
    }

}

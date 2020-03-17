import basicDataStructure.ListNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class L200To250 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode start = head;
        while (head != null) {
            if (head.val == val) {
                start = head.next;
            } else if (head.next != null && head.next.val == val) {
                ListNode theNext = head.next;
                while (theNext != null && theNext.val == val) {
                    head.next = theNext.next;
                    theNext = head.next;
                }
            }
            head = head.next;
        }
        return start;
    }

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes.size();
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() != nums.length;
    }

    public boolean isPowerOfTwo(int n) {

        if (n == 1) {
            return true;
        } else if (n < 1) {
            return false;
        }

        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }

    private ListNode reverseLinkedList(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    // 1. divide the list to two parts
    // 2. reverse the second part

    public boolean isPalindrome(ListNode head) {

        List<ListNode> target = new ArrayList<>();

        while (head != null) {
            target.add(head);
            head = head.next;
        }

        int j = target.size() - 1;
        int i = 0;
        boolean result = true;
        while (result && i < j) {
            result = target.get(i).val == target.get(j).val;
            i++;
            j--;
        }
        return result;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}

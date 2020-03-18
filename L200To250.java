import basicDataStructure.ListNode;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    public List<Integer> majorityElement(int[] nums) {

        if (nums.length < 3) {
            return Arrays.stream(nums).distinct().boxed().collect(Collectors.toList());
        }

        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            if (count.get(num) == null) {
                count.put(num, 1);
            } else {
                count.put(num, count.get(num) + 1);
                if (count.get(num) > nums.length / 3) {
                    result.add(num);
                }
            }
        }

        return result.stream().distinct().collect(Collectors.toList());
    }


    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        int start = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) { // find the end
                if (start == nums[i]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(String.valueOf(start) + "->" + String.valueOf(nums[i]));
                }
                start = nums[i + 1];
            }
        }

        if (start != nums[nums.length - 1]) {
            result.add(String.valueOf(start) + "->" + String.valueOf(nums[nums.length - 1]));
        } else {
            result.add(String.valueOf(start));
        }
        return result;
    }

}

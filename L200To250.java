import basicDataStructure.ListNode;
import basicDataStructure.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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
        if (nums.length == 0) {
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


    public int removeDuplicates(int[] nums) {
        return Arrays.stream(nums).distinct().toArray().length;
    }


    //FIXME 209
    public int minSubArrayLen(int s, int[] nums) {
        Arrays.sort(nums);
        int target = s;
        List<Integer> result = new ArrayList<>();
        int start = 0, end = nums.length - 1, times = 0;

        while (start < end) {
            if (nums[end] <= target) {
                target = target - nums[end];
                result.add(nums[end]);
                if (this.contains(nums, target, start, end)) {

                    System.out.println("here 1");

                    return result.size() + 1;
                }
                end--;
            } else if (nums[start] <= target) {
                target = target - nums[start];
                result.add(nums[start]);
                if (this.contains(nums, target, start, end)) {

                    System.out.println("here 2");

                    result.stream().forEach(System.out::println);

                    return result.size() + 1;
                }
                start++;
            } else if (nums[start] > target) {  // need to start over
                times++;
                result = new ArrayList<>();
                end = nums.length - times - 1;
                start = 0;
                target = s;
            }
            if (target == 0) {
                return result.size();
            }
        }
        return 0;
    }

    public boolean contains(final int[] arr, final int key, final int start, final int end) {
        return Arrays.stream(Arrays.copyOfRange(arr, start, end)).anyMatch(i -> i == key);
    }


    // 213. House Robber II
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robSub(Arrays.copyOfRange(nums, 0, n - 1)), robSub(Arrays.copyOfRange(nums, 1, n)));
    }


    private int robSub(int[] nums) {
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


    //230 Kth Smallest Element in a BST
    public int kthSmallest(TreeNode root, int k) {
        return this.kthSmallest(root, new AtomicInteger(0), k);
    }

    private int kthSmallest(TreeNode root, AtomicInteger i, int k) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // search in left subtree
        int left = kthSmallest(root.left, i, k); //left
        // if k'th smallest is found in left subtree, return it
        if (left != Integer.MAX_VALUE) { //center
            return left;
        }
        // if current element is k'th smallest, return its value
        if (i.incrementAndGet() == k) {
            return root.val;
        }

        return kthSmallest(root.right, i, k); // right
    }


    public int countLeftNode(TreeNode root) {

        if (root.left != null) {
            return this.countLeftNode(root.left) + 1;
        }
        return 1;
    }


    //216 Combination Sum III
    public List<List<Integer>> combinationSum3(int k, int n) {
        int target = n;
        List<List<Integer>> results = new ArrayList<>();


//        while (true) {
//
//            combinationSum3(k, n, new ArrayList<>())
//
//            break;
//        }

//        for (int i = 1; i <= 9; i++) {
//            if (target > i && (result.size() != k - 1)) { // the last one
//                result.add(i);
//                target = target - i;
//            } else if (result.size() == k - 1) {
//                result.add(target);
//                break;
//            }
//        }
//        results.add(result);
        return results;
    }

    private List<Integer> combinationSum3(int k, int n, List<Integer> nums, List<Integer> result) {

        int target = n;
        for (int i : nums) {
            if (target > i && (result.size() != k - 1)) { // the last one
                result.add(i);
                nums.remove(i);
                return combinationSum3(k - 1, n - i, nums, result);
            } else if (result.size() == k - 1) {
                result.add(target);
                return result;
            }
        }
        return result;
    }

}

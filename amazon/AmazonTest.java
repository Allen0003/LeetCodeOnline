package amazon;


import java.util.*;
import java.util.stream.Collectors;

import basicDataStructure.*;


public class AmazonTest {

    // Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.

// Note: The solution set must not contain duplicate triplets.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

    //n^3
    public List<List<Integer>> threeSumBrute(int[] nums) {
        // brute method 3 loops

        Arrays.sort(nums);
        Set<List<Integer>> results = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> result = new LinkedList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        results.add(result);
                    }
                }
            }
        }
        return results.stream().collect(Collectors.toList());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> results = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if ((nums[i] + nums[j] + nums[k]) == 0) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if ((nums[i] + nums[j] + nums[k]) > 0) {
                    k--;
                } else if ((nums[i] + nums[j] + nums[k]) < 0) {
                    j++;
                }
            }
        }

        return results.stream().collect(Collectors.toList());
    }

    // You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        boolean isOver = false;
        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            if (result == null) { // the first item
                result = new ListNode((l1Val + l2Val) % 10);
                current = result;
                isOver = l1Val + l2Val >= 10;
            } else {
                int over = isOver ? 1 : 0;
                current.next = new ListNode((over + l1Val + l2Val) % 10);
                current = current.next;
                isOver = l1Val + l2Val + over >= 10;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (isOver) {
            current.next = new ListNode(1);
        }

        return result;
    }


// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Example 1:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5

// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0

// In this case, no transaction is done, i.e. max profit = 0.

    public int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        boolean isFoundMIn = false;
        for (int i = 0; i < prices.length; i++) {
            if (isFoundMIn) {
                if (prices[i] > min && prices[i] - min > result) {
                    result = prices[i] - min;
                }
            }
            if (prices[i] < min) {
                min = prices[i];
                isFoundMIn = true;
            }
        }
        return result;
    }

    // Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return new ArrayList();

        Queue<TreeNode> waitingQueue = new ArrayDeque();
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        waitingQueue.add(root);
        Queue<TreeNode> theSameLevelQueue = new ArrayDeque();
        while (!waitingQueue.isEmpty()) { //when there are something inside
            TreeNode temp = waitingQueue.poll();
            result.add(temp.val);
            if (temp.left != null) {
                theSameLevelQueue.add(temp.left);
            }
            if (temp.right != null) {
                theSameLevelQueue.add(temp.right);
            }
            if (waitingQueue.isEmpty()) { // should more to next level
                results.add(result);
                result = new ArrayList<>();
                while (!theSameLevelQueue.isEmpty()) {
                    waitingQueue.add(theSameLevelQueue.poll());
                }
            }
        }
        return results;
    }

    //TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
//and it returns a short URL such as http://tinyurl.com/4e9iAk.
//
//Design the encode and decode methods for the TinyURL service. There is no restriction on how your
//encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL
//and the tiny URL can be decoded to the original URL.

    // Encodes a URL to a shortened URL.
//    public String encode(String longUrl) {
//
//    }
//
//    // Decodes a shortened URL to its original URL.
//    public String decode(String shortUrl) {
//
//    }


    //Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
//Examples:
//
//s = "leetcode"
//return 0.
//
//s = "loveleetcode",
//return 2.
//Note: You may assume the string contain only lowercase letters.


    public int firstUniqChar(String s) {

        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) { // i find something
                map.put(s.charAt(i), true);
            } else {
                map.put(s.charAt(i), false);
            }
        }

        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }


    // Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note: All inputs will be in lower-case.

    //n^2 * nlongn
    public List<List<String>> groupAnagramsBrute(String[] strs) {
        List<List<String>> result = new LinkedList<>();

        Map<Integer, Boolean> isFoundMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] currentChars = strs[i].toCharArray();
            Arrays.sort(currentChars);
            String sortedCurrent = new String(currentChars);
            List<String> layer = new ArrayList<>();
            for (int j = i + 1; j < strs.length; j++) {
                char[] targetChars = strs[j].toCharArray();
                Arrays.sort(targetChars);
                if (sortedCurrent.equals(new String(targetChars)) && isFoundMap.get(j) == null) { // find what I want
                    layer.add(strs[j]);
                    isFoundMap.put(j, true);
                }
            }
            if (!layer.isEmpty() || isFoundMap.get(i) == null) {
                layer.add(strs[i]);
                result.add(layer);
            }
        }
        return result;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        Arrays.sort(strs);
        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] currentChars = str.toCharArray();
            Arrays.sort(currentChars);
            String key = new String(currentChars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }


//Design a data structure that supports all following operations in average O(1) time.

//insert(val): Inserts an item val to the set if not already present.
//remove(val): Removes an item val from the set if present.
//getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

//Example:
// Init an empty set.
//RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
//randomSet.insert(1);

// Returns false as 2 does not exist in the set.
//randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
//randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
//randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
//randomSet.remove(1);

// 2 was already in the set, so return false.
//randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
//randomSet.getRandom();


    // Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.

// Note:
// You may assume k is always valid, 1 ≤ k ≤ array's length.

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }

// Given a digit string, return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below.

// 2 - abc
// 3 - def
// 4 - ghi
// 5 - jkl
// 6 - mno
// 7 - pqrs
// 8 - tuv
// 9 - wxyz

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        letterCombinationsRecursive(result, digits, "", 0, new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"});
        return result;
    }

    public void letterCombinationsRecursive(List<String> result, String digits, String current, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsRecursive(result, digits, current + letters.charAt(i), index + 1, mapping);
        }
    }


//Given a linked list, determine if it has a cycle in it.
//Follow up:
//Can you solve it without using extra space?

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode start1 = head;
        ListNode start2 = head.next;
        while (true) {
            if (start1.equals(start2)) {
                return true;
            }
            if (start1 == null || start1.next == null || start2 == null || start2.next == null || start2.next.next == null) {
                return false;
            }
            start1 = start1.next;
            start2 = start2.next.next;
        }
    }


    //Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

//Example:
//Input: "babad"
//Output: "bab"

//Note: "aba" is also a valid answer.

//Example:
//Input: "cbbd"
//Output: "bb"

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 1) {
            return s;
        }
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(this.getMiddlePoint(s, i, i + 1), this.getMiddlePoint(s, i, i));

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getMiddlePoint(String s, int left, int right) {
        if (left > right) {
            return 0;
        }
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (left + right) / 2;
    }


    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
//        key, , value
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }


    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int low = 0; low <= s.length(); low++) {
            if (!dp[low]) {
                continue;
            }
            for (int high = low + 1; high <= s.length(); high++) {
                if (wordDict.contains(s.substring(low, high))) {
                    dp[high] = true;
                }
            }
        }
        return dp[s.length()];
    }


    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.equals(p) || root.equals(q)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) { //can't find anything on the left subtree
            return right;
        } else if (right == null) { //can't find anything on the right subtree
            return left; // start from this point
        } else {
            return root;
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            System.out.println(Integer.toString(i, 2));
            String[] temp = Integer.toString(i, 2).split("");
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < temp.length; j++) {
                if (temp.equals('1')) {
                    tempList.add(nums[j]);
                }
            }
            result.add(tempList);
        }


//        for (int start = 0; start < nums.length; start++) {
//            for (int end = start; end < nums.length; end++) {
//                int index = end - start;  // for looping the array
//                System.out.println(index);
//                List<Integer> tempList = new ArrayList<>();
//                while (index >= 0) {
//                    tempList.add(nums[index]);
//                    index--;
//                }
//                result.add(tempList);
//            }
//        }
        return result;
    }


}
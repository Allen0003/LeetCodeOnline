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
}
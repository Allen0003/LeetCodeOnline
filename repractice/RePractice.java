package repractice;

import basicDataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RePractice {

    //035
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle = start + end / 2;
        while (true) {
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                start = middle;
                middle = (start + end) / 2;
            } else if (target < nums[middle]) {
                end = middle;
                middle = (start + end) / 2;
            }
            if (start + 1 >= end) { //can't find
                if (target == nums[start]) {
                    return start;
                } else if (target == nums[end]) {
                    return end;
                } else if (target < nums[start]) {
                    return start;
                } else if (target > nums[end]) {
                    return end + 1;
                }
                return start + 1;
            }
        }
    }

    // 226
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        } else if (root.right == null && root.left == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);


        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    //242
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (count1.get(s.charAt(i)) == null) {
                count1.put(s.charAt(i), 1);
            } else if (count1.get(s.charAt(i)) != null) {
                count1.put(s.charAt(i), count1.get(s.charAt(i)) + 1);
            }

            if (count2.get(t.charAt(i)) == null) {
                count2.put(t.charAt(i), 1);
            } else if (count2.get(t.charAt(i)) != null) {
                count2.put(t.charAt(i), count2.get(t.charAt(i)) + 1);
            }
        }

        return count1.equals(count2);
    }

    //111
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }

        if (root.right == null && root.left != null) {
            return minDepth(root.left);
        }
        if (root.right != null && root.left == null) {
            return minDepth(root.right);
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    //169
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int maxCount = 0;
        int result = 0;
        for (int num : nums) {
            if (count.get(num) == null) { // first
                count.put(num, 1);
                if (maxCount < 1){
                    maxCount = 1;
                    result = num;
                }
            } else {
                count.put(num, count.get(num) + 1);
                if (maxCount < count.get(num)){
                    maxCount = count.get(num);
                    result = num;
                }
            }
        }

        return result;
    }

}

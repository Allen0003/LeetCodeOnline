package practice;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3
 * exists or not in the array. </br>
 * Formally the function should: Return true if there exists i, j, k </br>
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return
 * false.</br>
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Examples:</br>
 * Given [1, 2, 3, 4, 5],</br>
 * return true.</br>
 * 
 * Given [5, 4, 3, 2, 1],</br>
 * return false.</br>
 * 
 * Thinking point: Assume we found one number A and another number B that is
 * larger than A. </br>
 * If we could find a third number C that is larger than B, we can return a
 * true. </br>
 * So the problem becomes how to update A and B to make them ready for C to be
 * discovered. </br>
 * We have to ensure that at least one number visited is smaller than B, </br>
 * then when C is discovered to be larger than B, we can return true. </br>
 * Meanwhile, we don't want to miss any possible C, </br>
 * which means B needs to be minimized, i.e. there has to be exactly one </br>
 * number smaller than B. In this way, B is lowered and lowered again </br>
 * to guarantee C is not gonna missed, larger than B is the minimum
 * requirement. </br>
 * 
 */

public class LeetCode334_IncreasingTripletSubsequence_M {
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		Integer upper = null, lower = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (upper != null) {
				if (nums[i] > upper) {
					return true;
				}
			}
			// finding lowest number here
			if (nums[i] <= lower) {
				lower = nums[i];
			} else {
				if (upper == null || nums[i] < upper) {
					upper = nums[i];
				}
			}
		}
		return false;
	}
}

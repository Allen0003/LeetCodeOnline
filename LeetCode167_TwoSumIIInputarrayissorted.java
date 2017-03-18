package practice;

/**
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.<br>
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.<br>
 * 
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.<br>
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 <br>
 * Output: index1=1, index2=2
 * 
 */

public class LeetCode167_TwoSumIIInputarrayissorted {

	public static void main(String[] args) {

	}

	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0) {
			return null;
		}
		int floor = 0, ceiling = numbers.length - 1;

		while (floor <= ceiling) {
			if (numbers[floor] + numbers[ceiling] > target) {
				ceiling--;
			} else if (numbers[floor] + numbers[ceiling] < target) {
				floor++;
			} else {
				return new int[] { floor + 1, ceiling + 1 };
			}
		}
		return null;
	}

}

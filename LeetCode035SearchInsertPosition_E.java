package practice;

/**
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.<br>
 * 
 * You may assume no duplicates in the array.<br>
 * 
 * Here are few examples.<br>
 * 
 * [1,3,5,6], 5 → 2<br>
 * [1,3,5,6], 2 → 1<br>
 * [1,3,5,6], 7 → 4<br>
 * [1,3,5,6], 0 → 0<br>
 * 
 */

public class LeetCode035SearchInsertPosition {

	public static void main(String[] args) {

		int[] input = new int[] { 1, 3 };
		int targer = 2;

		// System.out.println(3 / 2);

		System.out.println(new LeetCode035SearchInsertPosition().searchInsertI(input, targer));
	}

	public int searchInsertI(int[] nums, int target) {
		int floor = 0, ceiling = nums.length - 1;// array starts from zero
		int mid = floor + (ceiling - floor) / 2;
		// move ceiling or floor for further search
		while (floor <= ceiling) {
			if (target < nums[mid]) {
				ceiling = mid - 1;
			} else if (target > nums[mid]) {
				floor = mid + 1;
			} else {
				return mid;
			}
			mid = floor + (ceiling - floor) / 2;
		}
		return mid;
	}

	public int searchInsert(int[] nums, int target) {

		// only more index is not enough for solving binary search

		int steps = (nums.length - 1); // array starts from zero
		int thisTimeIndex = steps / 2;

		if (nums.length == 1) { // one case scenario
			if (nums[0] > target || nums[0] == target) {
				return 0;
			} else if (nums[0] < target) {
				return 1;
			}
		}

		while (steps != 0) {
			steps = steps / 2;
			// floor and ceiling cases
			if (thisTimeIndex < 0) {
				return 0;
			} else if (thisTimeIndex > nums.length - 1) {
				return nums.length - 1;
			}
			if (nums[thisTimeIndex] == target) {
				return thisTimeIndex;
			} else if (nums[thisTimeIndex] > target) {
				thisTimeIndex = thisTimeIndex - steps;
			} else if (nums[thisTimeIndex] < target) {
				thisTimeIndex = thisTimeIndex + steps;
			}
		}

		return thisTimeIndex;
	}

}

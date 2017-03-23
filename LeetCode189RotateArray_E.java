package practice;

/**
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, <br>
 * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * <br>
 * O(1) extra space
 */

public class LeetCode189RotateArray_E {

	public static void main(String args[]) {

		int temp[] = new int[] { 1, 2, 3, 4, 5 };
		new LeetCode189RotateArray_E().rotate(temp, 2);

		int temp2[] = new int[] { 1, 2, 3, 4, 5 };
		new LeetCode189RotateArray_E().rotateII(temp2, 2);

		for (int temp1 : temp) {
			System.out.print(temp1 + ",");
		}
		System.out.println();
		for (int temp1 : temp2) {
			System.out.print(temp1 + ",");
		}

	}

	// Reversal rotate O(1) space and in O(n) time
	public void rotateII(int[] nums, int k) {
		if (nums == null || k < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if (k > nums.length) {
			k = k % nums.length;
		}

		reversal(nums, 0, nums.length - k - 1);
		reversal(nums, nums.length - k, nums.length - 1);
		reversal(nums, 0, nums.length - 1);
	}

	public void reversal(int[] nums, int start, int end) {

		if (nums == null || nums.length == 1) {
			return;
		}
		while (end > start) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			end--;
			start++;
		}
	}

	// bubble rotate Time O(k*n)
	public void rotate(int[] nums, int k) {
		if (nums == null || k < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
		while (k > 0) {
			for (int i = nums.length - 1; i > 0; i--) {
				this.swap(i, i - 1, nums);
			}
			k--;
		}
	}

	public void swap(int indes1, int indes2, int[] input) {
		int temp = 0;
		temp = input[indes1];
		input[indes1] = input[indes2];
		input[indes2] = temp;
	}

}

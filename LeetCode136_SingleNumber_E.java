package practice;

import java.util.Arrays;

/**
 * problem description: </br>
 * Given an array of integers, every element appears twice except for one. Find
 * that single one. </br>
 * Note: </br>
 * Your algorithm should have a linear runtime complexity. </br>
 * Could you implement it without using extra memory? </br>
 */

public class LeetCode136_SingleNumber_E {

	// solution 1 : </br>

	// O(nlogn) version

	// first of all, sorting the targeted array then checking it. </br>
	// If there are the same character existed between n and n + 1 then it is
	// the ok character.
	// Otherwise this is the single one. </br>
	// The time complexity is O(nlogn)

	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length) {
			if ((i + 1) < nums.length && nums[i] == nums[i + 1]) {
				i = i + 2;
			} else {
				i++;
				return nums[i - 1];
			}
		}
		return 0;
	}

	// (very good solution)
	// solution 2 :
	//
	// ^ ==> xor in java </br>
	//
	// Using xor to solve this problem. Because xor is a changeable operator. We
	// can imagine that </br>
	//
	// 2^3^2 == 2^2^3 </br>
	//
	// As a result, it can easy filter the only single character. </br>
	public int singleNumber2(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;
	}
}

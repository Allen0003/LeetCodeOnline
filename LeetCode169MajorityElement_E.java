package practice;

import java.util.HashMap;
import java.util.Map;

public class LeetCode169MajorityElement_E {

	public static void main(String args[]) {

		new LeetCode169MajorityElement_E().majorityElement(new int[] { 3, 3, 4 });

	}

	public int majorityElement(int[] nums) {

		int max = 0;
		int result = 0;
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (count.get(nums[i]) != null) {
				count.put(nums[i], (count.get(nums[i])) + 1);
			} else {
				if (max == 0) {
					max = 1;
					result = nums[i];
				}
				count.put(nums[i], 1);
			}

			if (count.get(nums[i]) >= max) {
				max = count.get(nums[i]);
				result = nums[i];
			}
		}
		return result;
	}
}

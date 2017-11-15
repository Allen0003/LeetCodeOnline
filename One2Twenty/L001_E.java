package One2Twenty;

import java.util.HashMap;
import java.util.Map;

public class L001_E {

	public static void main(String[] args) {
		System.out.println(new L001_E().twoSum(new int[] { 3, 2, 4 }, 6));
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(nums[0], 0);
		for (int i = 1; i < nums.length; i++) {
			int compare = target - nums[i];
			if (map.containsKey(compare)) {
				return new int[] { map.get(compare), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSum_N2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}

package practice;

import java.util.HashSet;

// dynamic programming

public class L003_M {

	public static void main(String[] args) {
		System.out.println(new L003_M().lengthOfLongestSubstring("dvdf"));
	}

	// HashSet
	public int lengthOfLongestSubstring(String s) {
		int start = 0, end = 0, tempMax = 0;
		HashSet<Character> compare = new HashSet<Character>();
		while (end < s.length()) {
			if (!compare.contains(s.charAt(end))) {
				compare.add(s.charAt(end));
				tempMax = Math.max(compare.size(), tempMax);
				end++;
			} else {
				compare.remove(s.charAt(start));
				start++;
			}
		}
		return Math.max(tempMax, tempMax);
	}
}

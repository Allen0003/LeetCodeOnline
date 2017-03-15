package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s. <br>
 * For example,<br>
 * s = "anagram", t = "nagaram", return true.<br>
 * s = "rat", t = "car", return false.
 * 
 */

public class LeetCode242_ValidAnagram_E {

	public static void main(String args[]) {

		String input1 = "qooqoo";
		String input2 = "ooqooqqq";
		System.out.println(new LeetCode242_ValidAnagram_E().isAnagram(input1, input2));

	}

	public boolean isAnagram(String s, String t) {

		String[] temp_s = s.split("");
		String[] temp_t = t.split("");

		Map<String, Integer> mapS = new HashMap<String, Integer>();
		Map<String, Integer> mapT = new HashMap<String, Integer>();

		for (int i = 0; i < temp_s.length; i++) {
			if (mapS.get(temp_s[i]) != null) {
				mapS.put(temp_s[i], mapS.get(temp_s[i]) + 1);
			} else {
				mapS.put(temp_s[i], 1);
			}
		}

		for (int i = 0; i < temp_t.length; i++) {
			if (mapT.get(temp_t[i]) != null) {
				mapT.put(temp_t[i], mapT.get(temp_t[i]) + 1);
			} else {
				mapT.put(temp_t[i], 1);
			}
		}

		return mapT.equals(mapS);
	}

	// point 1: one map solution
	// point 2: map.containsKey <==> != null
	// point 3: using String.charAt(), not split
	public boolean isAnagramI(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			if (map.containsKey(c1)) {
				map.put(c1, map.get(c1) + 1);
			} else {
				map.put(c1, 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char c2 = t.charAt(i);
			if (map.containsKey(c2)) {
				if (map.get(c2) == 1) {
					map.remove(c2);
				} else {
					map.put(c2, map.get(c2) - 1);
				}
			} else {
				return false;
			}
		}
		if (map.size() > 0) {
			return false;
		}
		return true;
	}

}
